package com.huayu.XT.role.entity;

public class UPage {
    private Integer totalPage;//总页数
    private Integer totalNumber;//总条数
    private Integer currentPage;//当前页
    private Integer paging = 7;//分页

    public Integer getTotalPage() {
        return totalNumber % paging == 0 ? totalNumber / paging:totalNumber / paging+1;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPaging() {
        return paging;
    }

    public void setPaging(Integer paging) {
        this.paging = paging;
    }
}
