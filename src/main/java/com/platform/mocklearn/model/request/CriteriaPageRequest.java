package com.platform.mocklearn.model.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CriteriaPageRequest<E> extends BasePageRequest {

    @NotNull
    @Valid
    private E criteria;

    public E getCriteria() {
        return criteria;
    }

    public void setCriteria(E criteria) {
        this.criteria = criteria;
    }

    @Override
    public String toString() {
        return "CriteriaPageRequest{" +
                "criteria=" + criteria +
                '}';
    }
}
