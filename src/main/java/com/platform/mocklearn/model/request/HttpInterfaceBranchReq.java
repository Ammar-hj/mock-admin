package com.platform.mocklearn.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class HttpInterfaceBranchReq {
    @NotBlank
    private String name;

    @NotNull
    private String syncScript;

    @NotNull
    private String asyncScript;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSyncScript() {
        return syncScript;
    }

    public void setSyncScript(String syncScript) {
        this.syncScript = syncScript;
    }

    public String getAsyncScript() {
        return asyncScript;
    }

    public void setAsyncScript(String asyncScript) {
        this.asyncScript = asyncScript;
    }

    @Override
    public String toString() {
        return "HttpInterfaceBranchReq{" +
                "name='" + name + '\'' +
                ", syncScript='" + syncScript + '\'' +
                ", asyncScript='" + asyncScript + '\'' +
                '}';
    }
}
