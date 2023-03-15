package com.platform.mocklearn.model.entity;

public class InterfaceBranchWithBLOBs extends InterfaceBranch {
    private String syncScript;

    private String asyncScript;

    public String getSyncScript() {
        return syncScript;
    }

    public void setSyncScript(String syncScript) {
        this.syncScript = syncScript == null ? null : syncScript.trim();
    }

    public String getAsyncScript() {
        return asyncScript;
    }

    public void setAsyncScript(String asyncScript) {
        this.asyncScript = asyncScript == null ? null : asyncScript.trim();
    }
}