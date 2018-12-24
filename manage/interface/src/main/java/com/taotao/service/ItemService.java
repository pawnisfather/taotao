package com.taotao.service;

import com.taotao.util.EasyUIDataGridResult;

/**
 * Demo class
 *
 * @author apple
 * @date 2018/12/21 下午3:39
 */
public interface ItemService {
    public EasyUIDataGridResult getItemList(int page, int rows);
}
