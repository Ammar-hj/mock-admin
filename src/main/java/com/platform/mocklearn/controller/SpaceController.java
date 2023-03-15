package com.platform.mocklearn.controller;

import com.platform.mocklearn.enums.RespCodeEnum;
import com.platform.mocklearn.model.request.IdRequest;
import com.platform.mocklearn.model.request.SpaceRequest;
import com.platform.mocklearn.model.response.ApiRestResponse;
import com.platform.mocklearn.model.response.ConflictJudgementResponse;
import com.platform.mocklearn.model.response.SpaceListResponse;
import com.platform.mocklearn.services.SpaceService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/mock/space")
public class SpaceController {
    private static final Logger logger = LoggerFactory.getLogger(SpaceController.class);

    @Autowired
    SpaceService spaceService;

    @ApiOperation("添加节点")
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public ApiRestResponse addSpace(@Validated(value = {SpaceRequest.Insert.class}) @RequestBody SpaceRequest request) {
        spaceService.createSpace(request);
        return ApiRestResponse.success(RespCodeEnum.SUCCESS_CREATE_SPACE.getMsg());
    }

    @ApiOperation("修改节点")
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public ApiRestResponse updateSpace(@Validated(value = {SpaceRequest.Update.class}) @RequestBody SpaceRequest request) {
        spaceService.updateSpace(request);
        return ApiRestResponse.success(RespCodeEnum.SUCCESS_UPDATE_SPACE.getMsg());
    }

    @ApiOperation("删除节点")
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public ApiRestResponse deleteSpace(@Validated @RequestBody IdRequest request) {
        spaceService.deleteSpace(request.getId());
        return ApiRestResponse.success(RespCodeEnum.SUCCESS_DELETE_SPACE.getMsg());
    }

    @ApiOperation("获取节点列表")
    @RequestMapping(method = RequestMethod.POST, value = "/list")
    public ApiRestResponse<List<SpaceListResponse>> getSpaceList() {
        List<SpaceListResponse> resp = spaceService.queryTree();
        return ApiRestResponse.success(resp);
    }
}
