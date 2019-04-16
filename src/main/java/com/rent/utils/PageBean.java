package com.rent.utils;



import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

/**
 * 分页类
 */
public class PageBean<T> {
    /**
     * 页码，从1开始
     */
    private int pageNum;
    /**
     * 页面大小
     */
    private int pageSize;
    /**
     * 总数
     */
    private long total;
    /**
     * 总页数
     */
    private long pages;
    /**
     * 数据
     */
    private List<T> data;

    public PageBean(){}

    public PageBean(Page page){
        this.pageNum = page.getCurrent();
        this.pages = page.getPages();
        this.pageSize = page.getSize();
        this.total = page.getTotal();
        this.data = page.getRecords();

    }

    /**
     *
     * @param data 不分页的list，伪造分页
     */
    public PageBean(List<T> data) {
        this.data = data;
        this.pageNum = 1;
        this.pages = 1;
        this.pageSize = data.size();
        this.total = data.size();
    }

    public PageBean(List<T> data,Integer pageNum,Integer pageSize,Integer total) {
        this.data = data;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        if (total == 0) {
            this.pages = 0;
            this.pageNum = 0;
        }
        this.pages = this.total / this.pageSize;
        if (this.total % this.pageSize != 0) {
            this.pages++;
        }

    }


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", pages=" + pages +
                ", data=" + data +
                '}';
    }
}
