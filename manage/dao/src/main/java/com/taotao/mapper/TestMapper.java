package com.taotao.mapper;

import com.taotao.pojo.TbItemParam1;

import java.util.List;

/**
 * Demo class
 *
 * @author apple
 * @date 2018/12/20 下午3:26
 */
public interface TestMapper {

    /**
     *
     * @return 当前时间
     */
    public String queryNow();

    public List<TbItemParam1> selectAll();

}
