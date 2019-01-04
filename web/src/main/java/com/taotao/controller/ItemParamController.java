package com.taotao.controller;

import com.taotao.service.ItemParamService;
import com.taotao.util.TaotaoResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

/**
 * @author apple
 * @version V1.0
 * @className ItemParamController
 * @Description
 * @date 2019/1/3 下午5:01
 */

@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/query/itemcatid/{cid}")
    @ResponseBody
    public TaotaoResult getItemCatByCid(@PathVariable Long cid) {
        TaotaoResult result = itemParamService.getItemParamByCid(cid);
        return result;
    }

    @RequestMapping("/save/{cid}")
    @ResponseBody
    public TaotaoResult insertItemParam(@PathVariable Long cid, String paramData) {
        TaotaoResult result = itemParamService.insertItemParam(cid, paramData);
        return result;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult deleteItemParam( String ids) {
        System.out.println(ids);
        String[] split1 = ids.split(",");
        for(String a:split1){
            itemParamService.deleteItemParam(Long.parseLong(a));
        }

        return TaotaoResult.ok();
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult updateItemParam( String ids) {
        System.out.println(ids);
        String[] split1 = ids.split(",");
        for(String a:split1){
            itemParamService.updateItemParam(Long.parseLong(a));
        }

        return TaotaoResult.ok();
    }

}
