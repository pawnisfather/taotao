package com.taotao.service.Impl;

import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
import com.taotao.util.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author apple
 * @version V1.0
 * @className ItemParamServiceImpl
 * @Description
 * @date 2019/1/3 下午4:54
 */

@Service
public class ItemParamServiceImpl implements ItemParamService {

    @Autowired
    private TbItemParamMapper itemParamMapper;


    @Override
    public TaotaoResult getItemParamByCid(Long cid) {
        TbItemParamExample itemParamExample = new TbItemParamExample();
        TbItemParamExample.Criteria criteria = itemParamExample.createCriteria();
        criteria.andItemCatIdEqualTo(cid);
        List<TbItemParam> itemParams = itemParamMapper.selectByExampleWithBLOBs(itemParamExample);
        if (itemParams != null&&itemParams.size() > 0) {
            TbItemParam itemParam = itemParams.get(0);
            return TaotaoResult.ok(itemParam);
        }



        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult insertItemParam(Long cid, String paramData) {
        //创建一个pojo
        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramData);
        itemParam.setCreated(new Date());
        itemParam.setUpdated(new Date());
        //插入记录
        itemParamMapper.insert(itemParam);
        return TaotaoResult.ok();

    }

    @Override
    public TaotaoResult deleteItemParam(Long id) {
        itemParamMapper.deleteByPrimaryKey(id);
        return TaotaoResult.ok();


    }

    @Override
    public TaotaoResult updateItemParam(Long id) {
        TbItemParam tbItemParam2 = itemParamMapper.selectByPrimaryKey(id);
        Date date = new Date();
        tbItemParam2.setUpdated(date);
        itemParamMapper.updateByPrimaryKey(tbItemParam2);
//        itemParamMapper.updateByExample()
        return TaotaoResult.ok();
    }
}
