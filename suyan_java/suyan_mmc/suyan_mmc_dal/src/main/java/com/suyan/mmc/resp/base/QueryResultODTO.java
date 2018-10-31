package com.suyan.mmc.resp.base;


import java.io.Serializable;
import java.util.List;

public class QueryResultODTO<E> implements Serializable {
    private static final long serialVersionUID = 8189778548880809030L;

    /**
     * @Fields pageNo : 第几页
     */
    private int pageNo;

    /**
     * @Fields pageSize : 每页多少数据
     */
    private int pageSize;

    /**
     * @Fields totalPages : 总页数
     */
    private int totalPages;

    /**
     * @Fields totalRecords : 总记录数
     */
    private long totalRecords;

    /**
     * @Fields records : 返回记录列表
     */
    private List<E> records;


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

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<E> getRecords() {
        return records;
    }

    public void setRecords(List<E> records) {
        this.records = records;
    }
}
