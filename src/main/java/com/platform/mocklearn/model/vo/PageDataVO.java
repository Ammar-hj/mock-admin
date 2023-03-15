package com.platform.mocklearn.model.vo;

import com.platform.mocklearn.model.request.BasePageRequest;

import java.util.List;

public class PageDataVO<E> {
    private Integer page;
    private Integer itemsPerPage;
    private Long total;
    private List<E> list;

    public PageDataVO(BasePageRequest request) {
        this.page = request.getPage();
        this.itemsPerPage = request.getItemsPerPage();
    }

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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }
}
