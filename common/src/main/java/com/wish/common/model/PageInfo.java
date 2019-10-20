package com.wish.common.model;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wish on 2019/3/3.
 */
public class PageInfo<T> {

    private List<T> items;

    private int pageSize;   // 分页大小

    private int page;     // 当前页

    private int totalPage;  // 总页数

    private int totalCount; // 总记录数

    private int start = -1;

    public PageInfo() {

    }

    public PageInfo(int page, int pageSize) {
        setPage(page);
        setPageSize(pageSize);
        int start = (page - 1) * pageSize + 1;
        if (start < 1) {
            start = 1;
        }
        setStart(start);
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        if (this.pageSize < 0) {
            this.pageSize = 0;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
        if (this.pageSize < 0) {
            this.pageSize = 0;
        }
    }

    public int getStart() {

        if (start < 0 && pageSize > 0 && page > 0) {
            start = (page - 1) * pageSize;
        }

        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {

        this.totalCount = totalCount;

        if (pageSize != 0) {
            setTotalPage((totalCount + pageSize - 1) / pageSize);
        }
    }
}