package com.platform.mocklearn.controller;

import com.platform.mocklearn.model.response.ApiRestResponse;
import com.platform.mocklearn.model.response.CoreAddrResponse;
import com.platform.mocklearn.services.CoreAddrService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoreAddrController {

    @Autowired
    CoreAddrService coreAddrService;

    @ApiOperation("获取mock核心服务地址")
    @RequestMapping(method = RequestMethod.POST, value = "/mock_web/core/addr")
    public ApiRestResponse<CoreAddrResponse> queryCodeAddr() {
        CoreAddrResponse resp = coreAddrService.queryCoreAddr();
        return ApiRestResponse.success(resp);
    }

}
