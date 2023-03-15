package com.platform.mocklearn.services.impl;

import com.platform.mocklearn.model.response.CoreAddrResponse;
import com.platform.mocklearn.services.CoreAddrService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CoreAddrServiceImpl implements CoreAddrService {

    @Value("${mock.core.url-prefix}")
    private String urlPrefix;

    @Override
    public CoreAddrResponse queryCoreAddr() {
        CoreAddrResponse resp = new CoreAddrResponse();
        resp.setUrlPrefix(urlPrefix);
        return resp;
    }
}
