package com.platform.mocklearn.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedirectController {

    @ApiOperation("重定向到首页index.html")
    @RequestMapping(value = "/")
    public String redirect() {
        return "redirect:/web/index.html";
    }

}
