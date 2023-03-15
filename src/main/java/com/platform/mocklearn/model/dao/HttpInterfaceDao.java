package com.platform.mocklearn.model.dao;

import com.platform.mocklearn.model.request.HttpInterfaceKeyReq;
import com.platform.mocklearn.model.request.HttpInterfaceReq;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface HttpInterfaceDao {

    Long insert(HttpInterfaceReq httpInterface);

    void update(HttpInterfaceReq httpInterfaceReq);

    void delete(Long id);

    HttpInterfaceReq selectById(Long id);

    List<HttpInterfaceReq> queryBySpaceIdWithRowBoundsOrderByClause(Long spaceId, RowBounds rowBounds, String orderByClause);

    List<HttpInterfaceReq> queryAllWithRowBoundsOrderByClause(RowBounds rowBounds, String orderByClause);

    Long countAll();

    Long countBySpaceId(Long spaceId);

    HttpInterfaceReq queryByKey(HttpInterfaceKeyReq request);
}
