package com.taotao.controller;

import com.github.pagehelper.PageHelper;
import com.taotao.service.ItemService;
import com.taotao.util.EasyUIDataGridResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author apple
 * @version V1.0
 * @className PageController
 * @Description
 * @date 2018/12/20 下午11:31
 */

@Controller
public class PageController {

    private ItemService itemService;



    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUIDataGridResult getItemList( Integer page, Integer rows) {



        EasyUIDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }

    /**
     * 展示菜单页面
     * @param page
     * @return
     */
    @RequestMapping("/{page}")
    public String showItemList(@PathVariable String page){
        return page;
    }

}
