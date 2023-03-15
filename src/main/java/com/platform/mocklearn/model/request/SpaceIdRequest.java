package com.platform.mocklearn.model.request;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class SpaceIdRequest implements Serializable {

    @NotNull
    private Long spaceId;

    public Long getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Long spaceId) {
        this.spaceId = spaceId;
    }

    @Override
    public String toString() {
        return "SpaceIdRequest{" +
                "spaceId=" + spaceId +
                '}';
    }
}
