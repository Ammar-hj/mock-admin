package com.platform.mocklearn.model.entity;

import java.util.Date;

public class HttpInterface {
    private Long id;

    private String requestUri;

    private String requestMethod;

    private String description;

    private Boolean needAsyncCallback;

    private String configMode;

    private String callbackRequestUrl;

    private String callbackRequestMethod;

    private Integer syncDelay;

    private Integer asyncDelay;

    private Boolean isStart;

    private Long spaceId;

    private String lastUpdateUser;

    private String name;

    private String accessAuthority;

    private Date ctime;

    private Date mtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri == null ? null : requestUri.trim();
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod == null ? null : requestMethod.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getNeedAsyncCallback() {
        return needAsyncCallback;
    }

    public void setNeedAsyncCallback(Boolean needAsyncCallback) {
        this.needAsyncCallback = needAsyncCallback;
    }

    public String getConfigMode() {
        return configMode;
    }

    public void setConfigMode(String configMode) {
        this.configMode = configMode == null ? null : configMode.trim();
    }

    public String getCallbackRequestUrl() {
        return callbackRequestUrl;
    }

    public void setCallbackRequestUrl(String callbackRequestUrl) {
        this.callbackRequestUrl = callbackRequestUrl == null ? null : callbackRequestUrl.trim();
    }

    public String getCallbackRequestMethod() {
        return callbackRequestMethod;
    }

    public void setCallbackRequestMethod(String callbackRequestMethod) {
        this.callbackRequestMethod = callbackRequestMethod == null ? null : callbackRequestMethod.trim();
    }

    public Integer getSyncDelay() {
        return syncDelay;
    }

    public void setSyncDelay(Integer syncDelay) {
        this.syncDelay = syncDelay;
    }

    public Integer getAsyncDelay() {
        return asyncDelay;
    }

    public void setAsyncDelay(Integer asyncDelay) {
        this.asyncDelay = asyncDelay;
    }

    public Boolean getIsStart() {
        return isStart;
    }

    public void setIsStart(Boolean isStart) {
        this.isStart = isStart;
    }

    public Long getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser == null ? null : lastUpdateUser.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAccessAuthority() {
        return accessAuthority;
    }

    public void setAccessAuthority(String accessAuthority) {
        this.accessAuthority = accessAuthority == null ? null : accessAuthority.trim();
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
}