package com.platform.mocklearn.model.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.platform.mocklearn.enums.OpType;
import com.platform.mocklearn.enums.RespCodeEnum;
import com.platform.mocklearn.exception.MockException;
import com.platform.mocklearn.model.dao.HttpInterfaceSnapshotDao;
import com.platform.mocklearn.model.entity.HttpInterfaceSnapshot;
import com.platform.mocklearn.model.mapper.HttpInterfaceSnapshotMapper;
import com.platform.mocklearn.model.request.HttpInterfaceReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HttpInterfaceSnapshotDaoImpl implements HttpInterfaceSnapshotDao {

    @Autowired
    HttpInterfaceSnapshotMapper httpInterfaceSnapshotMapper;

    @Override
    public void create(HttpInterfaceReq httpInterfaceReq, OpType opType) {
        HttpInterfaceSnapshot httpInterfaceSnapshot = new HttpInterfaceSnapshot();
        httpInterfaceSnapshot.setHttpInterfaceId(httpInterfaceReq.getId());
        httpInterfaceSnapshot.setHttpInterfaceRequestMethod(httpInterfaceReq.getRequestMethod());
        httpInterfaceSnapshot.setHttpInterfaceRequestUri(httpInterfaceReq.getRequestUri());
        httpInterfaceSnapshot.setHttpInterfaceSpaceId(httpInterfaceReq.getSpaceId());
        httpInterfaceSnapshot.setHttpInterface(JSONObject.toJSONString(httpInterfaceReq));

        Date now = new Date();
        httpInterfaceSnapshot.setCtime(now);
        httpInterfaceSnapshot.setMtime(now);
        httpInterfaceSnapshot.setOpType(opType.name());

        int count = httpInterfaceSnapshotMapper.insert(httpInterfaceSnapshot);
        if (count != 1) {
            throw new MockException(RespCodeEnum.INSERT_ERROR);
        }
    }
}
