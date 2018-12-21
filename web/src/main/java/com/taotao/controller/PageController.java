package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author apple
 * @version V1.0
 * @className PageController
 * @Description
 * @date 2018/12/20 下午11:31
 */

@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex(){
        return "index";
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
