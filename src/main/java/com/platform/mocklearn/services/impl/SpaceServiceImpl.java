package com.platform.mocklearn.services.impl;

import com.platform.mocklearn.enums.RespCodeEnum;
import com.platform.mocklearn.enums.SpaceEnum;
import com.platform.mocklearn.exception.MockException;
import com.platform.mocklearn.model.dao.SpaceDao;
import com.platform.mocklearn.model.entity.Space;
import com.platform.mocklearn.model.mapper.SpaceMapper;
import com.platform.mocklearn.model.request.SpaceRequest;
import com.platform.mocklearn.model.response.SpaceListResponse;
import com.platform.mocklearn.services.SpaceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

import static com.platform.mocklearn.common.Constants.ROOT_SPACE_ID;

@Service
public class SpaceServiceImpl implements SpaceService {

    @Autowired
    SpaceDao spaceDao;

    @Override
    public void createSpace(SpaceRequest spaceRequest) {
        SpaceRequest pre;
        if (spaceRequest.getParentId().equals(ROOT_SPACE_ID)) {
            // TODO 身份判断，暂时不加
            pre = new SpaceRequest();
            pre.setParentId(ROOT_SPACE_ID);
            pre.setLevel(0);
            pre.setAccessAuthority(SpaceEnum.PUBLIC);
        } else {
            pre = spaceDao.queryById(spaceRequest.getParentId());
            if (pre == null) {
                throw new MockException(RespCodeEnum.NOT_FOUND_PARENT_SPACE);
            }
        }
        if (!pre.canCreateSpace()) {
            throw new MockException(RespCodeEnum.CAN_NOT_CREATE_SPACE_UNDER_THIS_LEVEL);
        }
        spaceRequest.setAccessAuthority(pre.getAccessAuthority());
        spaceRequest.setLevel(pre.getLevel() + 1);

        spaceDao.create(spaceRequest);
    }

    @Override
    public void updateSpace(SpaceRequest spaceRequest) {
        SpaceRequest pre = spaceDao.queryById(spaceRequest.getId());
        if (pre == null) {
            throw new MockException(RespCodeEnum.NOT_FOUND_SPACE);
        }
        spaceRequest.setParentId(null);
        spaceRequest.setAccessAuthority(null);
        spaceRequest.setLevel(null);

        spaceDao.update(spaceRequest);
    }

    @Override
    @Transactional
    public void deleteSpace(Long id) {
        SpaceRequest pre = spaceDao.queryById(id);
        if (pre == null) {
            throw new MockException(RespCodeEnum.NOT_FOUND_SPACE);
        }
        // TODO 补充删除http表中关联数据
        spaceDao.delete(id);
    }

    @Override
    public List<SpaceListResponse> queryTree() {
        SpaceListResponse spaceList = new SpaceListResponse();
        spaceList.setId(ROOT_SPACE_ID);
        spaceList.setPath(new LinkedList<>());
        return buildSpaceTree(spaceList);
    }

    private List<SpaceListResponse> buildSpaceTree(SpaceListResponse spaceListResponse) {
        List<SpaceRequest> spaceRequestList
                = spaceDao.queryByParentIdOrderByClause(spaceListResponse.getId(), "mtime desc");
        List<SpaceListResponse> spaceList = new LinkedList<>();
        spaceRequestList.forEach(spaceRequest -> {
            SpaceListResponse space = convertToResp(spaceRequest, spaceListResponse.getPath());
            space.setChildren(buildSpaceTree(space));
            spaceList.add(space);
        });
        return spaceList;
    }

    private SpaceListResponse convertToResp(SpaceRequest spaceRequest, List<Long> parentPath) {
        SpaceListResponse spaceListResponse = new SpaceListResponse();
        BeanUtils.copyProperties(spaceRequest, spaceListResponse);
        spaceListResponse.setAllowCreateSpace(spaceRequest.canCreateSpace());
        spaceListResponse.setAllowCreateInterface(spaceRequest.canCreateInterface());
        spaceListResponse.setVariable(true);// TODO修改校验身份

        List<Long> newPath = new LinkedList<>(parentPath);
        newPath.add(spaceRequest.getId());
        spaceListResponse.setPath(newPath);
        return spaceListResponse;
    }
}
