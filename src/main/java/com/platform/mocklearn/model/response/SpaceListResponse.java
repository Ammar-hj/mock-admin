package com.platform.mocklearn.model.response;

import com.platform.mocklearn.model.request.SpaceRequest;

import java.util.List;

public class SpaceListResponse extends SpaceRequest {

    private List<SpaceListResponse> children;
    private List<Long> path;
    private Boolean allowCreateInterface;
    private Boolean allowCreateSpace;
    private Boolean variable;

    public List<SpaceListResponse> getChildren() {
        return children;
    }

    public void setChildren(List<SpaceListResponse> children) {
        this.children = children;
    }

    public List<Long> getPath() {
        return path;
    }

    public void setPath(List<Long> path) {
        this.path = path;
    }

    public Boolean getAllowCreateInterface() {
        return allowCreateInterface;
    }

    public void setAllowCreateInterface(Boolean allowCreateInterface) {
        this.allowCreateInterface = allowCreateInterface;
    }

    public Boolean getAllowCreateSpace() {
        return allowCreateSpace;
    }

    public void setAllowCreateSpace(Boolean allowCreateSpace) {
        this.allowCreateSpace = allowCreateSpace;
    }

    public Boolean getVariable() {
        return variable;
    }

    public void setVariable(Boolean variable) {
        this.variable = variable;
    }
}
