package com.platform.mocklearn.services;

import com.platform.mocklearn.model.request.SpaceRequest;
import com.platform.mocklearn.model.response.SpaceListResponse;

import java.util.List;

public interface SpaceService {
    void createSpace(SpaceRequest spaceRequest);

    void updateSpace(SpaceRequest spaceRequest);

    void deleteSpace(Long id);

    List<SpaceListResponse> queryTree();
}
