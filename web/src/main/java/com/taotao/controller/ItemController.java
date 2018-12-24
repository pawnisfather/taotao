package com.taotao.controller;

import com.taotao.service.ItemService;
import com.taotao.util.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author apple
 * @version V1.0
 * @className ItemController
 * @Description
 * @date 2018/12/23 下午11:37
 */

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;


    @RequestMapping(value = "/item/list",method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getAllList(Integer page,Integer rows){
//        1.引入服务
//        2。注入服务
//        3.调用服务的方法

        return itemService.getItemList(page,rows);

    }
}
