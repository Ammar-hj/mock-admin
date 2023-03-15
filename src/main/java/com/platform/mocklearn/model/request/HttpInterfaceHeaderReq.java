package com.platform.mocklearn.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class HttpInterfaceHeaderReq {
    @NotBlank
    private String name;

    @NotNull
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HttpInterfaceHeaderReq{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
