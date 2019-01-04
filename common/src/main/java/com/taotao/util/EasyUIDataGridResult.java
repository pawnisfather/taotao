package com.taotao.util;

import java.io.Serializable;
import java.util.List;

/**
 * 商品列表查询的返回的数据类
 * @title EasyUIDataGridResult.java
 * <p>description：</p>
 * <p>company: www.itheima.com</p>
 * @author ljh
 * @version 1.0
 */
public class EasyUIDataGridResult implements Serializable {
    private Integer total;
    private List rows;
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
    public List getRows() {
        return rows;
    }
    public void setRows(List rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "EasyUIDataGridResult{" +
                "total=" + total +
                ", rows=" + rows.toString() +
                '}';
    }
}
