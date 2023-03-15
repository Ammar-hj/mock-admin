package com.platform.mocklearn.model.request;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class IdRequest implements Serializable {

    @NotNull
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IdRequest{" +
                "id=" + id +
                '}';
    }
}
