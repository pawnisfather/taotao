package com.taotao.service;

import com.taotao.pojo.TbItemParam;
import com.taotao.util.TaotaoResult;

import java.util.List;

/**
 * @author apple
 * @version V1.0
 * @className ItemParamService
 * @Description
 * @date 2019/1/3 下午4:54
 */

public interface ItemParamService {

    public TaotaoResult getItemParamByCid(Long cid);
    public TaotaoResult insertItemParam(Long cid, String paramData);

    public TaotaoResult deleteItemParam(Long id);

    public TaotaoResult updateItemParam(Long id);
}
