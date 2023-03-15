package com.platform.mocklearn.controller;

import com.platform.mocklearn.model.request.*;
import com.platform.mocklearn.model.response.ApiRestResponse;
import com.platform.mocklearn.model.response.ConflictJudgementResponse;
import com.platform.mocklearn.model.response.HttpInterfaceResp;
import com.platform.mocklearn.model.vo.PageDataVO;
import com.platform.mocklearn.services.HttpInterfaceService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/mock/http/")
public class HttpInterfaceController {
    private static final Logger logger = LoggerFactory.getLogger(HttpInterfaceController.class);

    @Autowired
    HttpInterfaceService httpInterfaceService;

    @ApiOperation("添加http接口")
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ApiRestResponse<HttpInterfaceResp> addInterfaceHttp(@Validated(value = {HttpInterfaceReq.Insert.class}) @RequestBody HttpInterfaceReq httpInterfaceReq) {
        HttpInterfaceResp httpInterfaceResponse = httpInterfaceService.insertInterface(httpInterfaceReq);
        return ApiRestResponse.success(httpInterfaceResponse);
    }

    @ApiOperation("修改http接口")
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ApiRestResponse updateInterfaceHttp(@Validated(value = {HttpInterfaceReq.Update.class}) @RequestBody HttpInterfaceReq httpInterfaceReq) {
        httpInterfaceService.updateInterface(httpInterfaceReq);
        return ApiRestResponse.success();
    }

    @ApiOperation("删除http接口")
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public ApiRestResponse deleteInterfaceHttp(@Validated @RequestBody IdRequest idRequest) {
        httpInterfaceService.deleteInterface(idRequest.getId());
        return ApiRestResponse.success();
    }

    @ApiOperation("获取所有接口")
    @RequestMapping(method = RequestMethod.POST, value = "/queryAll")
    public ApiRestResponse<PageDataVO> queryAll(@Validated @RequestBody BasePageRequest request) {
        PageDataVO resp = httpInterfaceService.queryAll(request);
        return ApiRestResponse.success(resp);
    }

    @ApiOperation("根据节点查询")
    @RequestMapping(method = RequestMethod.POST, value = "/queryBySpaceId")
    public ApiRestResponse<PageDataVO> queryBySpaceId(@Validated @RequestBody CriteriaPageRequest<SpaceIdRequest> request) {
        PageDataVO resp = httpInterfaceService.queryBySpaceId(request);
        return ApiRestResponse.success(resp);
    }

    @ApiOperation("根据接口ID查询")
    @RequestMapping(method = RequestMethod.POST, value = "/queryById")
    public ApiRestResponse<HttpInterfaceResp> queryById(@Validated @RequestBody IdRequest request) {
        HttpInterfaceResp resp = httpInterfaceService.queryById(request.getId());
        return ApiRestResponse.success(resp);
    }

    @ApiOperation("判断接口是否冲突")
    @RequestMapping(method = RequestMethod.POST, value = "/conflictDetection")
    public ApiRestResponse<ConflictJudgementResponse> conflictDetection(@Validated @RequestBody HttpInterfaceConflictDetectionRequest request) {
        ConflictJudgementResponse resp = httpInterfaceService.conflictDetection(request);
        return ApiRestResponse.success(resp);
    }
}
