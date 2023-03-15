package com.platform.mocklearn.model.dao.impl;

import com.platform.mocklearn.enums.ConfigMode;
import com.platform.mocklearn.enums.HttpHeaderType;
import com.platform.mocklearn.enums.RespCodeEnum;
import com.platform.mocklearn.enums.SpaceEnum;
import com.platform.mocklearn.exception.MockException;
import com.platform.mocklearn.model.dao.HttpInterfaceDao;
import com.platform.mocklearn.model.dao.HttpInterfaceHeaderDao;
import com.platform.mocklearn.model.dao.InterfaceBranchDao;
import com.platform.mocklearn.model.entity.HttpInterface;
import com.platform.mocklearn.model.entity.HttpInterfaceExample;
import com.platform.mocklearn.model.entity.HttpInterfaceWithBLOBs;
import com.platform.mocklearn.model.mapper.HttpInterfaceMapper;
import com.platform.mocklearn.model.request.HttpInterfaceKeyReq;
import com.platform.mocklearn.model.request.HttpInterfaceReq;
import org.apache.commons.lang3.EnumUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class HttpInterfaceDaoImpl implements HttpInterfaceDao {

    @Autowired
    HttpInterfaceMapper httpInterfaceMapper;

    @Autowired
    HttpInterfaceHeaderDao httpInterfaceHeaderDao;

    @Autowired
    InterfaceBranchDao interfaceBranchDao;

    @Override
    @Transactional
    public Long insert(HttpInterfaceReq httpInterfaceReq) {
        HttpInterfaceWithBLOBs httpInterfaceDB = convertToDO(httpInterfaceReq);
        Date now = new Date();
        httpInterfaceDB.setCtime(now);
        httpInterfaceDB.setMtime(now);
        httpInterfaceDB.setId(null);

        int count;
        try {
            count = httpInterfaceMapper.insert(httpInterfaceDB);
        } catch (DuplicateKeyException ex) {
            throw new MockException(RespCodeEnum.INTERFACE_EXISTS);
        }
        if (count != 1) {
            throw new MockException(RespCodeEnum.INSERT_ERROR);
        }

        HttpInterfaceExample httpInterfaceExample = new HttpInterfaceExample();
        httpInterfaceExample.createCriteria().andRequestMethodEqualTo(httpInterfaceDB.getRequestMethod()).andRequestUriEqualTo(httpInterfaceDB.getRequestUri());
        List<HttpInterfaceWithBLOBs> httpInterfaceWithBLOBs = httpInterfaceMapper.selectByExampleWithBLOBs(httpInterfaceExample);
        if (httpInterfaceWithBLOBs.size() != 1) {
            throw new MockException(RespCodeEnum.DATA_NUM_ERROR);
        }

        Long httpInterfaceId = httpInterfaceWithBLOBs.get(0).getId();
        httpInterfaceHeaderDao.batchCreate(httpInterfaceReq.getResponseHeaderList(), httpInterfaceId, HttpHeaderType.RESPONSE);
        httpInterfaceHeaderDao.batchCreate(httpInterfaceReq.getResponseHeaderList(), httpInterfaceId, HttpHeaderType.CALLBACK_REQUEST);
        interfaceBranchDao.batchCreate(httpInterfaceReq.getBranchScriptList(), httpInterfaceId);
        return httpInterfaceId;
    }

    @Override
    public void update(HttpInterfaceReq httpInterfaceReq) {
        HttpInterfaceWithBLOBs httpInterface = convertToDO(httpInterfaceReq);
        httpInterface.setMtime(null);
        httpInterface.setCtime(new Date());

        int count;
        try {
            count = httpInterfaceMapper.updateByPrimaryKeySelective(httpInterface);
        } catch (DuplicateKeyException e) {
            throw new MockException(RespCodeEnum.INTERFACE_EXISTS);
        }

        if (count != 1) {
            throw new MockException(RespCodeEnum.UPDATE_ERROR);
        }

        Long httpInterfaceId = httpInterfaceReq.getId();

        httpInterfaceHeaderDao.batchDelete(httpInterfaceId, HttpHeaderType.RESPONSE);
        httpInterfaceHeaderDao.batchCreate(
                httpInterfaceReq.getResponseHeaderList(), httpInterfaceId, HttpHeaderType.RESPONSE);

        httpInterfaceHeaderDao.batchDelete(httpInterfaceId, HttpHeaderType.CALLBACK_REQUEST);
        httpInterfaceHeaderDao.batchCreate(
                httpInterfaceReq.getCallbackRequestHeaderList(), httpInterfaceId, HttpHeaderType.CALLBACK_REQUEST);

        interfaceBranchDao.batchDelete(httpInterfaceId);
        interfaceBranchDao.batchCreate(
                httpInterfaceReq.getBranchScriptList(), httpInterfaceId);
    }

    @Override
    public void delete(Long id) {
        httpInterfaceHeaderDao.batchDelete(id, HttpHeaderType.RESPONSE);
        httpInterfaceHeaderDao.batchDelete(id, HttpHeaderType.CALLBACK_REQUEST);
        interfaceBranchDao.batchDelete(id);

        int count = httpInterfaceMapper.deleteByPrimaryKey(id);
        if (count == 0) {
            throw new MockException(RespCodeEnum.NOT_FOUND_INTERFACE);
        } else if (count != 1) {
            throw new MockException(RespCodeEnum.DELETE_ERROR);
        }
    }

    @Override
    public HttpInterfaceReq selectById(Long id) {
        HttpInterface httpInterface = httpInterfaceMapper.selectByPrimaryKey(id);
        if (httpInterface == null) {
            return null;
        }
        return convertToReq(httpInterface);
    }

    @Override
    public List<HttpInterfaceReq> queryBySpaceIdWithRowBoundsOrderByClause(Long spaceId, RowBounds rowBounds, String orderByClause) {
        HttpInterfaceExample example = new HttpInterfaceExample();
        example.createCriteria().andSpaceIdEqualTo(spaceId);
        example.setOrderByClause(orderByClause);
        return convertToReqList(httpInterfaceMapper.selectByExampleWithRowBounds(example, rowBounds));
    }

    @Override
    public List<HttpInterfaceReq> queryAllWithRowBoundsOrderByClause(RowBounds rowBounds, String orderByClause) {
        HttpInterfaceExample example = new HttpInterfaceExample();
        example.setOrderByClause(orderByClause);
        return convertToReqList(httpInterfaceMapper.selectByExampleWithRowBounds(example, rowBounds));
    }

    @Override
    public Long countAll() {
        return httpInterfaceMapper.countByExample(new HttpInterfaceExample());
    }

    @Override
    public Long countBySpaceId(Long spaceId) {
        HttpInterfaceExample example = new HttpInterfaceExample();
        example.createCriteria().andSpaceIdEqualTo(spaceId);
        return httpInterfaceMapper.countByExample(example);
    }

    @Override
    public HttpInterfaceReq queryByKey(HttpInterfaceKeyReq request) {
        HttpInterfaceExample example = new HttpInterfaceExample();
        example.createCriteria().andRequestUriEqualTo(request.getRequestMethod()).andRequestMethodEqualTo(request.getRequestMethod());
        List<HttpInterface> httpInterfaceDOList = httpInterfaceMapper.selectByExample(example);
        int resultSize = httpInterfaceDOList.size();
        if (resultSize == 0) {
            return null;
        } else if (resultSize == 1) {
            return convertToReq(httpInterfaceDOList.get(0));
        } else {
            throw new MockException(RespCodeEnum.NOT_FOUND_HTTP_INTERFACE_DATA);
        }
    }

    private List<HttpInterfaceReq> convertToReqList(List<HttpInterface> httpInterfacesList) {
        List<HttpInterfaceReq> httpInterfaceReqList = new LinkedList<>();
        httpInterfacesList.forEach(httpInterfaceDO -> httpInterfaceReqList.add(convertToReq(httpInterfaceDO)));
        return httpInterfaceReqList;
    }

    private HttpInterfaceWithBLOBs convertToDO(HttpInterfaceReq httpInterfaceReq) {
        HttpInterfaceWithBLOBs httpInterface = new HttpInterfaceWithBLOBs();
        BeanUtils.copyProperties(httpInterfaceReq, httpInterface);
        httpInterface.setConfigMode(httpInterfaceReq.getConfigMode().name());
        httpInterface.setAccessAuthority(httpInterfaceReq.getSpaceEnum().name());
        return httpInterface;
    }

    private HttpInterfaceReq convertToReq(HttpInterface httpInterface) {
        HttpInterfaceReq httpInterfaceReq = new HttpInterfaceReq();
        BeanUtils.copyProperties(httpInterface, httpInterfaceReq);
        httpInterfaceReq.setConfigMode(EnumUtils.getEnum(ConfigMode.class, httpInterface.getConfigMode()));
        httpInterfaceReq.setSpaceEnum(EnumUtils.getEnum(SpaceEnum.class, httpInterface.getAccessAuthority()));

        Long id = httpInterface.getId();
        httpInterfaceReq.setResponseHeaderList(httpInterfaceHeaderDao.batchQuery(id, HttpHeaderType.RESPONSE));
        httpInterfaceReq.setCallbackRequestHeaderList(httpInterfaceHeaderDao.batchQuery(id, HttpHeaderType.CALLBACK_REQUEST));
        httpInterfaceReq.setBranchScriptList(interfaceBranchDao.batchQuery(id));
        return httpInterfaceReq;
    }
}
