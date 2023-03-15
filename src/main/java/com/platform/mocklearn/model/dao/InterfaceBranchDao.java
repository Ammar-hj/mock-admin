package com.platform.mocklearn.model.dao;

import com.platform.mocklearn.model.entity.InterfaceBranch;
import com.platform.mocklearn.model.request.HttpInterfaceBranchReq;

import java.util.List;

public interface InterfaceBranchDao {
    void batchCreate(List<HttpInterfaceBranchReq> interfaceBranchList, Long httpInterfaceId);

    List<HttpInterfaceBranchReq> batchQuery(Long httpInterfaceId);

    void batchDelete(Long id);
}
