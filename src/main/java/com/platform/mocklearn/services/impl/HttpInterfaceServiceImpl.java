package com.platform.mocklearn.services.impl;

import com.platform.mocklearn.common.Constants;
import com.platform.mocklearn.common.HttpInterfaceCacheManager;
import com.platform.mocklearn.common.RowBoundsConverter;
import com.platform.mocklearn.enums.OpType;
import com.platform.mocklearn.enums.RespCodeEnum;
import com.platform.mocklearn.exception.MockException;
import com.platform.mocklearn.handler.SecurityContextHolder;
import com.platform.mocklearn.model.dao.HttpInterfaceDao;
import com.platform.mocklearn.model.dao.HttpInterfaceSnapshotDao;
import com.platform.mocklearn.model.dao.SpaceDao;
import com.platform.mocklearn.model.request.*;
import com.platform.mocklearn.model.response.ConflictJudgementResponse;
import com.platform.mocklearn.model.response.HttpInterfaceResp;
import com.platform.mocklearn.model.vo.PageDataVO;
import com.platform.mocklearn.services.HttpInterfaceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class HttpInterfaceServiceImpl implements HttpInterfaceService {

    @Autowired
    HttpInterfaceDao httpInterfaceDao;

    @Autowired
    SpaceDao spaceDao;

    @Autowired
    HttpInterfaceCacheManager httpInterfaceCacheManager;

    @Autowired
    HttpInterfaceSnapshotDao httpInterfaceSnapshotDao;

    @Override
    public HttpInterfaceResp insertInterface(HttpInterfaceReq httpInterfaceReq) {
        SpaceRequest space = spaceDao.queryById(httpInterfaceReq.getSpaceId());
        checkValid(space);
        httpInterfaceReq.setSpaceEnum(space.getAccessAuthority());
//        httpInterfaceReq.setLastUpdateUser(SecurityContextHolder.getUsername());
        httpInterfaceReq.setLastUpdateUser("tester");
        Long id = httpInterfaceDao.insert(httpInterfaceReq);
        return convertToResp(httpInterfaceDao.selectById(id));
    }

    @Override
    public void updateInterface(HttpInterfaceReq httpInterfaceReq) {
        HttpInterfaceReq oldHttpInterfaceReq = httpInterfaceDao.selectById(httpInterfaceReq.getId());
        checkValidInterface(oldHttpInterfaceReq);

        SpaceRequest spaceReq = spaceDao.queryById(httpInterfaceReq.getSpaceId());
        checkValid(spaceReq);

        httpInterfaceReq.setSpaceEnum(spaceReq.getAccessAuthority());
        httpInterfaceReq.setLastUpdateUser(SecurityContextHolder.getUsername());

        httpInterfaceCacheManager.clear(oldHttpInterfaceReq);
        httpInterfaceSnapshotDao.create(oldHttpInterfaceReq, OpType.UPDATE);
        httpInterfaceDao.update(httpInterfaceReq);
    }

    @Override
    public void deleteInterface(Long id) {
        HttpInterfaceReq httpInterfaceReq = httpInterfaceDao.selectById(id);
        checkValidInterface(httpInterfaceReq);
        httpInterfaceCacheManager.clear(httpInterfaceReq);
        httpInterfaceDao.delete(id);
    }

    @Override
    public PageDataVO<HttpInterfaceResp> queryAll(BasePageRequest request){
        PageDataVO<HttpInterfaceResp> pageDataVO = new PageDataVO<>(request);
        pageDataVO.setList(convertToRespList(httpInterfaceDao.queryAllWithRowBoundsOrderByClause(
                RowBoundsConverter.convert(request), "mtime desc")));
        pageDataVO.setTotal(httpInterfaceDao.countAll());
        return pageDataVO;
    }

    @Override
    public PageDataVO<HttpInterfaceResp> queryBySpaceId(CriteriaPageRequest<SpaceIdRequest> request){
        Long spaceId = request.getCriteria().getSpaceId();
        PageDataVO<HttpInterfaceResp> pagingDataResp = new PageDataVO<>(request);
        pagingDataResp.setList(convertToRespList(httpInterfaceDao.queryBySpaceIdWithRowBoundsOrderByClause(
                spaceId, RowBoundsConverter.convert(request), "mtime desc")));
        pagingDataResp.setTotal(httpInterfaceDao.countBySpaceId(spaceId));
        return pagingDataResp;
    }

    @Override
    public HttpInterfaceResp queryById(Long id){
        HttpInterfaceReq httpInterfaceBO = httpInterfaceDao.selectById(id);
        if (httpInterfaceBO == null) {
            throw new MockException(RespCodeEnum.NOT_FOUND_INTERFACE);
        }
        return convertToResp(httpInterfaceBO);
    }

    @Override
    public ConflictJudgementResponse conflictDetection(HttpInterfaceConflictDetectionRequest request){
        ConflictJudgementResponse conflictJudgementResponse = new ConflictJudgementResponse();
        conflictJudgementResponse.setDetectable(true);

        HttpInterfaceKeyReq httpInterfaceKeyReq = new HttpInterfaceKeyReq();
        httpInterfaceKeyReq.setRequestUri(request.getUri());
        httpInterfaceKeyReq.setRequestMethod(request.getMethod());
        HttpInterfaceReq httpInterface = httpInterfaceDao.queryByKey(httpInterfaceKeyReq);
        if (httpInterface == null || httpInterface.getId().equals(request.getId())) {
            conflictJudgementResponse.setConflict(false);
        } else {
            conflictJudgementResponse.setConflict(true);
        }
        return conflictJudgementResponse;
    }

    private List<HttpInterfaceResp> convertToRespList(List<HttpInterfaceReq> httpInterfaceReqList){
        List<HttpInterfaceResp> httpInterfaceRespList = new LinkedList<>();
        httpInterfaceReqList.forEach(httpInterface
                -> httpInterfaceRespList.add(convertToResp(httpInterface)));
        return httpInterfaceRespList;
    }

    private void checkValid(SpaceRequest spaceRequest) {
        if (spaceRequest == null) {
            throw new MockException(RespCodeEnum.NOT_FOUND_PARENT_SPACE);
        }
        if (!spaceRequest.canCreateInterface()) {
            throw new MockException(RespCodeEnum.CAN_NOT_CREATE_INTERFACE_UNDER_THIS_LEVEL);
        }
    }

    private void checkValidInterface(HttpInterfaceReq oldHttpInterfaceReq) {
        if (oldHttpInterfaceReq == null) {
            throw new MockException(RespCodeEnum.NOT_FOUND_PARENT_SPACE);
        }
        // TODO
//        if (!PrivilegeVerifier.hasPermission(oldHttpInterfaceBO.getAccessAuthority())) {
//            throw new BizException(ResultCode.PERMISSION_DENIED);
//        }
    }

    private HttpInterfaceResp convertToResp(HttpInterfaceReq httpInterfaceReq) {
        HttpInterfaceResp httpInterfaceResp = new HttpInterfaceResp();
        BeanUtils.copyProperties(httpInterfaceReq, httpInterfaceResp);

        Long spaceId = httpInterfaceReq.getSpaceId();
        LinkedList<Long> path = new LinkedList<>();
        while (!spaceId.equals(Constants.ROOT_SPACE_ID)) {
            path.addFirst(spaceId);
            spaceId = spaceDao.queryById(spaceId).getParentId();
        }
        httpInterfaceResp.setPath(path);
        return httpInterfaceResp;
    }
}
