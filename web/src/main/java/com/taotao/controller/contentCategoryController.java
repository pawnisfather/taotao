package com.taotao.controller;

import com.taotao.centent.service.ContentCategoryService;
import com.taotao.pojo.TbContentCategory;
import com.taotao.util.EasyUITreeNode;
import com.taotao.util.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author apple
 * @version V1.0
 * @className contentCategoryController
 * @Description
 * @date 2019/1/9 上午11:15
 */
@Controller
public class contentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping(value = "/content/category/list",method = RequestMethod.GET)
    @ResponseBody
    public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value = "id",defaultValue = "0") Long parentid){
        List<EasyUITreeNode> contentCategoryList = contentCategoryService.getContentCategoryList(parentid);
        return contentCategoryList;
    }

    @RequestMapping(value = "/content/category/create",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createContentCategory(@RequestParam(value = "parentId") Long parentid, @RequestParam(value = "name")String name){

        TaotaoResult contentCategory = contentCategoryService.createContentCategory(parentid, name);
        return contentCategory;
    }


    @RequestMapping(value = "/content/category/delete",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult deleteContentCategory(Long id){
        contentCategoryService.deleteContentCategory(id);
        return TaotaoResult.ok();
    }

    @RequestMapping(value = "/content/category/update",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult deleteContentCategory(Long id,String name){
        contentCategoryService.updateContentCagegory(id,name);
        return TaotaoResult.ok();
    }




}
