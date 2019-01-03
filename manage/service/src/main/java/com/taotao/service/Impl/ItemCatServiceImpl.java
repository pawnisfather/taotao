package com.taotao.service.Impl;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.service.ItemCatService;
import com.taotao.util.EasyUITreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类管理
 * @author apple
 * @version V1.0
 * @className ItemCatServiceImpl
 * @Description
 * @date 2018/12/27 下午10:17
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<EasyUITreeNode> getItemCatList(Long parentId) {
        TbItemCatExample tbItemCatexample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatexample.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(tbItemCatexample);
        List<EasyUITreeNode> resultList = new ArrayList<>();
        for(TbItemCat tbItemCat:tbItemCats){
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            resultList.add(node);

        }


        return resultList;
    }
}
