package com.hikarirms.retail.common.dto;

import lombok.Getter;

@Getter
public class BasePageRequest {

    public static final int DEFAULT_PAGE_NUMBER = 1;
    public static final int DEFAULT_PAGE_SIZE = 10;

    private int pageNumber;
    private int pageSize;
    private String sort;

    public BasePageRequest() {
        this.pageNumber = DEFAULT_PAGE_NUMBER;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.sort = null;
    }

    public BasePageRequest(int pageNumber) {
        validatePageNumber(pageNumber);
        this.pageNumber = pageNumber;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.sort = null;
    }

    public BasePageRequest(int pageNumber, int pageSize) {
        validatePageNumber(pageNumber);
        validatePageSize(pageSize);
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sort = null;
    }

    public BasePageRequest(int pageNumber, int pageSize, String sort) {
        validatePageNumber(pageNumber);
        validatePageSize(pageSize);
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sort = sort;
    }

    public void setPageNumber(int pageNumber) {
        validatePageNumber(pageNumber);
        this.pageNumber = pageNumber;
    }

    public void setPageSize(int pageSize) {
        validatePageSize(pageSize);
        this.pageSize = pageSize;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    private void validatePageNumber(int pageNumber) {
        if (pageNumber < 1) throw new IllegalArgumentException("pageNumber must be greater than 0");
    }

    private void validatePageSize(int pageSize) {
        if (pageSize < 1) throw new IllegalArgumentException("pageSize must be greater than 0");
    }

}
