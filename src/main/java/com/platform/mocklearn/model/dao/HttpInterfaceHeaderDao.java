package com.platform.mocklearn.model.dao;

import com.platform.mocklearn.enums.HttpHeaderType;
import com.platform.mocklearn.model.request.HttpInterfaceHeaderReq;

import java.util.List;

public interface HttpInterfaceHeaderDao {
    void batchCreate(List<HttpInterfaceHeaderReq> httpInterfaceHeaderBOListList, Long httpInterfaceId, HttpHeaderType type);

    List<HttpInterfaceHeaderReq> batchQuery(Long httpInterfaceId, HttpHeaderType type);

    void batchDelete(Long id, HttpHeaderType httpHeaderType);
}
