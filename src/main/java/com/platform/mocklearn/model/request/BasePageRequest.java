package com.platform.mocklearn.model.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class BasePageRequest{

    @NotNull
    @Min(1)
    private Integer page;

    @NotNull
    @Min(0)
    @Max(20)
    private Integer itemsPerPage;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    @Override
    public String toString() {
        return "BasePageRequest{" +
                "page=" + page +
                ", itemsPerPage=" + itemsPerPage +
                '}';
    }
}
