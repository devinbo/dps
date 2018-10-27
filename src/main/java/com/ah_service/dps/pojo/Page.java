package com.ah_service.dps.pojo;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * 用于接收前端传递的参数
 */
public class Page<T> extends PageInfo<T> {
    private int page; //当前页
    private int rows; //每页显示的行数
    private long total; //总记录数
    private boolean _search; //是否进行搜索操作
    private String nd; //本次查询随机id;
    private String sidx; //排序字段
    private String sord; //排序类型

    //过滤条件
    private String filters; //过滤条件

    private String searchField;
    private String searchString;
    private String searchOper;

    public Page() {
    }

     public Page(Map<String, Object> map) {
         this.page = map.get("page") == null ? 0 :  Integer.valueOf((String) map.get("page"));
         this.rows = map.get("rows") == null ? 0 : Integer.valueOf((String) map.get("rows"));
         this.total = map.get("total") == null ? 0 : Long.valueOf((String) map.get("rows"));
         this._search = map.get("_search") == null ? false : Boolean.valueOf((String)map.get("_search"));
         this.nd = map.get("nd") == null ? null : (String) map.get("nd");
         this.sidx = map.get("sidx") == null ? null : (String) map.get("sidx");
         this.sord = map.get("sord") == null ? null : (String) map.get("sord");
         this.filters = map.get("filters") == null ? null : (String) map.get("filters");
         this.searchField = map.get("searchField") == null ? null : (String) map.get("searchField");
         this.searchString = map.get("searchString") == null ? null : (String) map.get("searchString");
         this.searchOper = map.get("searchOper") == null ? null : (String) map.get("searchOper");
     }

    /**
     * 处理查询条件
     */
    public void dealSearch(Object object) {

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.setPageNum(page);
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.setPageSize(10);
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public boolean is_search() {
        return _search;
    }

    public void set_search(boolean _search) {
        this._search = _search;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        if(!StringUtils.isEmpty(sidx)) {
            this.setOrderBy(sidx + " " + (this.sord == null ? "" : this.sord));
        }else{
            this.setOrderBy(null);
        }
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        //如果字段已经设置过值，那么就设置排序方式
        if(!StringUtils.isEmpty(sidx)) {
            this.setOrderBy(this.sidx + " " +sord);
        }
        this.sord = sord;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchOper() {
        return searchOper;
    }

    public void setSearchOper(String searchOper) {
        this.searchOper = searchOper;
    }

    @Override
    public void setTotal(long total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", rows=" + rows +
                ", total=" + total +
                ", _search=" + _search +
                ", nd='" + nd + '\'' +
                ", sidx='" + sidx + '\'' +
                ", sord='" + sord + '\'' +
                ", filters='" + filters + '\'' +
                ", searchField='" + searchField + '\'' +
                ", searchString='" + searchString + '\'' +
                ", searchOper='" + searchOper + '\'' +
                '}';
    }
}
