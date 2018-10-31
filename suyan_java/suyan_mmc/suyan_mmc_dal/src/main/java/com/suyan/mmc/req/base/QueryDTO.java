package com.suyan.mmc.req.base;


import java.io.Serializable;

public class QueryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields pageNo : 第几页
     */
    private int pageNo = 1;

    /**
     * @Fields pageSize : 每页多少数据
     */
    private int pageSize = 10;

    /**
     * @Fields order : 哪个字段排序
     */
    private String order;

    /**
     * @Fields orderBy : 升序or降序
     */
    private String orderBy;

    /**
     * @Fields returnFields : 指定返回哪些字段
     */
    private String returnFields;


    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getReturnFields() {
        return returnFields;
    }

    public void setReturnFields(String returnFields) {
        this.returnFields = returnFields;
    }
}
