package com.taotao.service;

import com.taotao.util.EasyUITreeNode;

import javax.annotation.Resource;
import java.util.List;

/**
 * Demo class
 *
 * @author apple
 * @date 2018/12/27 下午10:15
 */


public interface ItemCatService {
    List<EasyUITreeNode> getItemCatList(Long parentId);
}
