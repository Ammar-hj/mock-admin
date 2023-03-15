package com.platform.mocklearn.model.dao.impl;

import com.platform.mocklearn.enums.RespCodeEnum;
import com.platform.mocklearn.enums.SpaceEnum;
import com.platform.mocklearn.exception.MockException;
import com.platform.mocklearn.model.dao.SpaceDao;
import com.platform.mocklearn.model.entity.Space;
import com.platform.mocklearn.model.entity.SpaceExample;
import com.platform.mocklearn.model.mapper.SpaceMapper;
import com.platform.mocklearn.model.request.SpaceRequest;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class SpaceDaoImpl implements SpaceDao {

    @Autowired
    SpaceMapper spaceMapper;

    @Override
    public SpaceRequest queryById(Long id) {
        Space space = spaceMapper.selectByPrimaryKey(id);
        if (space == null) return null;

        SpaceRequest spaceRequest = new SpaceRequest();
        BeanUtils.copyProperties(space, spaceRequest);
        spaceRequest.setAccessAuthority(EnumUtils.getEnum(SpaceEnum.class, space.getAccessAuthority()));
        return spaceRequest;
    }

    @Override
    public void create(SpaceRequest spaceRequest) {
        Space space = new Space();
        BeanUtils.copyProperties(spaceRequest, space);
        if (spaceRequest.getAccessAuthority() != null) {
            space.setAccessAuthority(spaceRequest.getAccessAuthority().name());
        }
        space.setId(null);
        Date now = new Date();
        space.setCtime(now);
        space.setMtime(now);

        int count;
        try {
            count = spaceMapper.insert(space);
        } catch (DuplicateKeyException e) {
            throw new MockException(RespCodeEnum.INTERFACE_BRANCH_EXISTS);
        }
        if (count != 1) {
            throw new MockException(RespCodeEnum.INSERT_ERROR);
        }
    }

    @Override
    public void update(SpaceRequest spaceRequest) {
        Space space = new Space();
        BeanUtils.copyProperties(spaceRequest, space);
        if (spaceRequest.getAccessAuthority() != null) {
            space.setAccessAuthority(spaceRequest.getAccessAuthority().name());
        }
        space.setCtime(null);
        space.setMtime(new Date());

        int count;
        try {
            count = spaceMapper.updateByPrimaryKeySelective(space);
        } catch (DuplicateKeyException e) {
            throw new MockException(RespCodeEnum.SPACE_EXISTS);
        }
        if (count == 0) {
            throw new MockException(RespCodeEnum.NOT_FOUND_SPACE);
        } else if (count != 1) {
            throw new MockException(RespCodeEnum.UPDATE_ERROR);
        }
    }

    @Override
    public void delete(Long id) {
        int resultSize = spaceMapper.deleteByPrimaryKey(id);
        if (resultSize == 0) {
            throw new MockException(RespCodeEnum.NOT_FOUND_SPACE);
        } else if (resultSize != 1) {
            throw new MockException(RespCodeEnum.DELETE_ERROR);
        }
    }

    @Override
    public List<SpaceRequest> queryByParentIdOrderByClause(Long parentId, String orderByClause) {
        SpaceExample example = new SpaceExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        example.setOrderByClause(orderByClause);
        return convertToList(spaceMapper.selectByExample(example));
    }

    private List<SpaceRequest> convertToList(List<Space> spaceListDB) {
        List<SpaceRequest> spaceList = new LinkedList<>();
        spaceListDB.forEach(space -> spaceList.add(convertToResp(space)));
        return spaceList;
    }

    private SpaceRequest convertToResp(Space space) {
        SpaceRequest spaceRequest = new SpaceRequest();
        BeanUtils.copyProperties(space, spaceRequest);
        spaceRequest.setAccessAuthority(EnumUtils.getEnum(SpaceEnum.class, space.getAccessAuthority()));
        return spaceRequest;
    }
}
