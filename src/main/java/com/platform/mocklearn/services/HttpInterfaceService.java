package com.platform.mocklearn.services;

import com.platform.mocklearn.model.request.*;
import com.platform.mocklearn.model.response.ConflictJudgementResponse;
import com.platform.mocklearn.model.response.HttpInterfaceResp;
import com.platform.mocklearn.model.vo.PageDataVO;

public interface HttpInterfaceService {
    HttpInterfaceResp insertInterface(HttpInterfaceReq httpInterfaceReq);

    void updateInterface(HttpInterfaceReq httpInterfaceReq);

    void deleteInterface(Long id);

    PageDataVO<HttpInterfaceResp> queryAll(BasePageRequest request);

    PageDataVO<HttpInterfaceResp> queryBySpaceId(CriteriaPageRequest<SpaceIdRequest> request);

    HttpInterfaceResp queryById(Long id);

    ConflictJudgementResponse conflictDetection(HttpInterfaceConflictDetectionRequest request);
}
