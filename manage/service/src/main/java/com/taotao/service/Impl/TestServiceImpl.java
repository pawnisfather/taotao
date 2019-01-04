package com.taotao.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TestMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemParam1;
import com.taotao.service.TestService;
import com.taotao.util.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author apple
 * @version V1.0
 * @className ServiceImpl
 * @Description
 * @date 2018/12/20 下午3:32
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    /**
     * 测试查询时间
     * @return
     */
    @Override
    public String queryNow() {
        return testMapper.queryNow();
    }

    @Override
    public EasyUIDataGridResult selectAll(int page, int rows) {
        PageHelper.startPage(page, rows);
        List<TbItemParam1> tbItemParam1s = testMapper.selectAll();
        PageInfo<TbItemParam1> pageInfo = new PageInfo<>(tbItemParam1s);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int)pageInfo.getTotal());
        result.setRows(tbItemParam1s);

        return result;
    }




}
