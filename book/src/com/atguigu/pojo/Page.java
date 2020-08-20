package com.atguigu.pojo;

import java.util.List;

/**
 * Page是分页模型的对象
 *
 * @param <T> 是具体的模块的JavaBean类
 */
public class Page<T> {

    public static final Integer PAGE_SIZE = 4;

    //访问URL
    private String url;

    //当前页码
    private int pageNo;
    //总页码
    private int pageTotal;
    //总记录数
    private int pageTotalCount;
    //每页数量
    private int pageSize = PAGE_SIZE;
    //当前页数据
    private List<T> items;

    public Page() {
    }

    public Page(String url, int pageNo, int pageTotal, int pageTotalCount, int pageSize, List<T> items) {
        this.url = url;
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageTotalCount = pageTotalCount;
        this.pageSize = pageSize;
        this.items = items;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(int pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "url='" + url + '\'' +
                ", pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageTotalCount=" + pageTotalCount +
                ", pageSize=" + pageSize +
                ", items=" + items +
                '}';
    }

}
