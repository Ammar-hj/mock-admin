package com.platform.mocklearn.model.dao;

import com.platform.mocklearn.enums.OpType;
import com.platform.mocklearn.model.request.HttpInterfaceReq;

public interface HttpInterfaceSnapshotDao {
    void create(HttpInterfaceReq httpInterfaceReq, OpType opType);
}
