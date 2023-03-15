package com.platform.mocklearn.model.dao.impl;

import com.platform.mocklearn.enums.HttpHeaderType;
import com.platform.mocklearn.enums.RespCodeEnum;
import com.platform.mocklearn.exception.MockException;
import com.platform.mocklearn.model.dao.HttpInterfaceHeaderDao;
import com.platform.mocklearn.model.entity.HttpInterfaceHeader;
import com.platform.mocklearn.model.entity.HttpInterfaceHeaderExample;
import com.platform.mocklearn.model.mapper.HttpInterfaceHeaderMapper;
import com.platform.mocklearn.model.request.HttpInterfaceHeaderReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class HttpInterfaceHeaderDaoImpl implements HttpInterfaceHeaderDao {

    @Autowired
    HttpInterfaceHeaderMapper httpInterfaceHeaderMapper;

    @Override
    public void batchCreate(List<HttpInterfaceHeaderReq> httpInterfaceHeaderBOListList, Long httpInterfaceId, HttpHeaderType type) {
        httpInterfaceHeaderBOListList.forEach(httpInterfaceHeaderBO -> {
            HttpInterfaceHeader httpInterfaceHeaderDO = convertToDO(httpInterfaceHeaderBO, httpInterfaceId, type);

            int count;
            try {
                count = httpInterfaceHeaderMapper.insert(httpInterfaceHeaderDO);
            } catch (DuplicateKeyException e) {
                throw new MockException(RespCodeEnum.INTERFACE_HEADER_EXISTS);
            }

            if (count != 1) {
                throw new MockException(RespCodeEnum.INSERT_ERROR);
            }
        });
    }

    @Override
    public List<HttpInterfaceHeaderReq> batchQuery(Long httpInterfaceId, HttpHeaderType type) {
        HttpInterfaceHeaderExample example = new HttpInterfaceHeaderExample();
        example.createCriteria()
                .andHttpInterfaceIdEqualTo(httpInterfaceId)
                .andTypeEqualTo(type.name());
        return convertToReqList(httpInterfaceHeaderMapper.selectByExample(example));
    }

    @Override
    public void batchDelete(Long id, HttpHeaderType httpHeaderType){
        HttpInterfaceHeaderExample example = new HttpInterfaceHeaderExample();
        example.createCriteria().andHttpInterfaceIdEqualTo(id).andTypeEqualTo(httpHeaderType.name());
        httpInterfaceHeaderMapper.deleteByExample(example);
    }

    private HttpInterfaceHeader convertToDO(HttpInterfaceHeaderReq httpInterfaceHeaderReq, Long httpInterfaceId, HttpHeaderType httpHeaderType) {
        HttpInterfaceHeader httpInterfaceHeader = new HttpInterfaceHeader();
        BeanUtils.copyProperties(httpInterfaceHeaderReq, httpInterfaceHeader);
        httpInterfaceHeader.setHttpInterfaceId(httpInterfaceId);
        httpInterfaceHeader.setType(httpHeaderType.name());
        return httpInterfaceHeader;
    }

    private HttpInterfaceHeaderReq convertToReq(HttpInterfaceHeader httpInterfaceHeader) {
        HttpInterfaceHeaderReq httpInterfaceHeaderReq = new HttpInterfaceHeaderReq();
        BeanUtils.copyProperties(httpInterfaceHeader, httpInterfaceHeaderReq);
        return httpInterfaceHeaderReq;
    }

    private List<HttpInterfaceHeaderReq> convertToReqList(List<HttpInterfaceHeader> httpInterfaceHeaderList) {
        List<HttpInterfaceHeaderReq> httpInterfaceHeaderReqs = new LinkedList<>();
        httpInterfaceHeaderList.forEach(httpInterfaceHeader -> httpInterfaceHeaderReqs.add(convertToReq(httpInterfaceHeader)));
        return httpInterfaceHeaderReqs;
    }

}
