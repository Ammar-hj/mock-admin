package com.platform.mocklearn.model.entity;

import java.util.Date;

public class HttpInterfaceSnapshot {
    private Long id;

    private Long httpInterfaceId;

    private String httpInterfaceRequestUri;

    private String httpInterfaceRequestMethod;

    private Long httpInterfaceSpaceId;

    private String opType;

    private Date ctime;

    private Date mtime;

    private String httpInterface;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHttpInterfaceId() {
        return httpInterfaceId;
    }

    public void setHttpInterfaceId(Long httpInterfaceId) {
        this.httpInterfaceId = httpInterfaceId;
    }

    public String getHttpInterfaceRequestUri() {
        return httpInterfaceRequestUri;
    }

    public void setHttpInterfaceRequestUri(String httpInterfaceRequestUri) {
        this.httpInterfaceRequestUri = httpInterfaceRequestUri == null ? null : httpInterfaceRequestUri.trim();
    }

    public String getHttpInterfaceRequestMethod() {
        return httpInterfaceRequestMethod;
    }

    public void setHttpInterfaceRequestMethod(String httpInterfaceRequestMethod) {
        this.httpInterfaceRequestMethod = httpInterfaceRequestMethod == null ? null : httpInterfaceRequestMethod.trim();
    }

    public Long getHttpInterfaceSpaceId() {
        return httpInterfaceSpaceId;
    }

    public void setHttpInterfaceSpaceId(Long httpInterfaceSpaceId) {
        this.httpInterfaceSpaceId = httpInterfaceSpaceId;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType == null ? null : opType.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getHttpInterface() {
        return httpInterface;
    }

    public void setHttpInterface(String httpInterface) {
        this.httpInterface = httpInterface == null ? null : httpInterface.trim();
    }
}