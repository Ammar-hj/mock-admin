package com.platform.mocklearn.model.response;

import com.platform.mocklearn.model.request.HttpInterfaceReq;

import java.util.List;

public class HttpInterfaceResp extends HttpInterfaceReq {

    private List<Long> path;

    private Boolean variable;

    public List<Long> getPath() {
        return path;
    }

    public void setPath(List<Long> path) {
        this.path = path;
    }

    public Boolean getVariable() {
        return variable;
    }

    public void setVariable(Boolean variable) {
        this.variable = variable;
    }
}
