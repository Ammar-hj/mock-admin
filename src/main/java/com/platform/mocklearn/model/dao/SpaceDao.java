package com.platform.mocklearn.model.dao;

import com.platform.mocklearn.model.request.SpaceRequest;

import java.util.List;

public interface SpaceDao {
    SpaceRequest queryById(Long id);

    void create(SpaceRequest spaceRequest);

    void update(SpaceRequest spaceRequest);

    void delete(Long id);

    List<SpaceRequest> queryByParentIdOrderByClause(Long parentId, String orderByClause);
}
