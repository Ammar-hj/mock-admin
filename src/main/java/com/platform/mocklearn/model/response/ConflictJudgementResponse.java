package com.platform.mocklearn.model.response;

public class ConflictJudgementResponse {
    private Boolean conflict;
    private Boolean detectable;

    public Boolean getConflict() {
        return conflict;
    }

    public void setConflict(Boolean conflict) {
        this.conflict = conflict;
    }

    public Boolean getDetectable() {
        return detectable;
    }

    public void setDetectable(Boolean detectable) {
        this.detectable = detectable;
    }
}
