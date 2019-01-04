package com.taotao.service;

import com.taotao.pojo.TbItemParam1;
import com.taotao.util.EasyUIDataGridResult;

import java.util.List;

/**
 * Demo class
 *
 * @author apple
 * @date 2018/12/20 下午3:30
 */


public interface TestService {



    public String queryNow();

    public EasyUIDataGridResult selectAll(int page, int rows);
}
