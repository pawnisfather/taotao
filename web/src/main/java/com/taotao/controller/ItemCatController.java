package com.taotao.controller;

import com.taotao.service.ItemCatService;
import com.taotao.util.EasyUITreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品分类管理controller
 * @author apple
 * @version V1.0
 * @className ItemCatController
 * @Description
 * @date 2018/12/27 下午11:33
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(value = "id",defaultValue = "0") Long parentid){
        return itemCatService.getItemCatList(parentid);

    }

}
