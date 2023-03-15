package com.platform.mocklearn.model.request;

import javax.validation.constraints.NotNull;

public class HttpInterfaceConflictDetectionRequest {
    @NotNull
    private Long id;

    @NotNull
    private String uri;

    @NotNull
    private String method;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "HttpInterfaceConflictDetectionRequest{" +
                "id=" + id +
                ", uri='" + uri + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
