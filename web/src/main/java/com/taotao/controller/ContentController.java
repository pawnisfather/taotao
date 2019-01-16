package com.taotao.controller;

import com.taotao.centent.service.ContentService;
import com.taotao.pojo.TbContent;
import com.taotao.util.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author apple
 * @version V1.0
 * @className ContentController
 * @Description
 * @date 2019/1/10 上午10:59
 */

@Controller
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/content/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult saveContent(TbContent tbContent){
        return contentService.saveContent(tbContent);

    }

}
