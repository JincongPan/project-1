package com.rent.form;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;

public class BaseInfoBean {
    public static int DEFAULT_PAGE_NUM = 1;
    public static int DEFAULT_PAGE_SIZE = 10;

    protected Integer pageNum;
    protected Integer pageSize;
    protected String order;
    protected String sortField;

    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public <E> Page<E> getPage() {
        if (pageNum == null || pageSize == null) {
            return null;
        }

        Page page = new Page(pageNum, pageSize);
        if (!StringUtils.isBlank(sortField) && !StringUtils.isBlank(order)) {
            page.setOpenSort(true);
            page.setOrderByField(sortField);
            page.setAsc(order.equalsIgnoreCase("asc"));
        }
        return page;
    }

    public <E> Page<E> createPage() {
        Page page = new Page<>(BaseInfoBean.DEFAULT_PAGE_NUM, BaseInfoBean.DEFAULT_PAGE_SIZE);
        if (!StringUtils.isBlank(sortField) && !StringUtils.isBlank(order)) {
            page.setOpenSort(true);
            page.setOrderByField(sortField);
            page.setAsc(order.equalsIgnoreCase("asc"));
        }
        return page;
    }
    public <E> Page<E> createPage(int pageNum,int pageSize) {
        Page page = new Page<>(pageNum, pageSize);
        if (!StringUtils.isBlank(sortField) && !StringUtils.isBlank(order)) {
            page.setOpenSort(true);
            page.setOrderByField(sortField);
            page.setAsc(order.equalsIgnoreCase("asc"));
        }
        return page;
    }
}
