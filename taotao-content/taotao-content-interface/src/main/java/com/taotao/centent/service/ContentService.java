package com.taotao.centent.service;

import com.taotao.pojo.TbContent;
import com.taotao.util.TaotaoResult;

import java.util.List;

/**
 * 内容添加服务层
 * Demo class
 *
 * @author apple
 * @date 2019/1/10 上午10:29
 */
public interface ContentService {
    public TaotaoResult saveContent(TbContent tbContent);

    public List<TbContent> getContentByCatId(Long id);

}
