package com.taotao.centent.service;

import com.taotao.util.EasyUITreeNode;
import com.taotao.util.TaotaoResult;

import java.util.List;

/**
 * Demo class
 *
 * @author apple
 * @date 2019/1/9 上午11:01
 */
public interface ContentCategoryService {
    public List<EasyUITreeNode> getContentCategoryList(Long parentId);

    public TaotaoResult createContentCategory(Long parentId,String name);

    public TaotaoResult deleteContentCategory(Long id);

    public TaotaoResult updateContentCagegory(Long id,String name);

}
