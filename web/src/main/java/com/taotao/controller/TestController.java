package com.taotao.controller;

import com.taotao.pojo.TbItemParam1;
import com.taotao.service.TestService;
import com.taotao.util.EasyUIDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.List;

/**
 * @author apple
 * @version V1.0
 * @className TestController
 * @Description
 * @date 2018/12/20 下午3:58
 */
@Controller
public class TestController {


    @Autowired
    private TestService testService;


    @RequestMapping("/aaa")
    @ResponseBody
    public String querytime() {

        return testService.queryNow();

    }



    @RequestMapping(value = "/item/param/list", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getAllList(Integer page, Integer rows) {
//        1.引入服务
//        2。注入服务
//        3.调用服务的方法

        EasyUIDataGridResult easyUIDataGridResult = testService.selectAll(page, rows);

//        List rows1 = easyUIDataGridResult.getRows();
//        for (Iterator it = rows1.iterator(); it.hasNext();){
//            List<TbItemParam1> next = (List<TbItemParam1>) it.next();
//            for (Iterator i1 =next.iterator();i1.hasNext();){
//                TbItemParam1 next1 = (TbItemParam1)i1.next();
//                System.out.println(next1.getItemCatName());
//            }
//
//        }
        System.out.println(easyUIDataGridResult.toString());

        return easyUIDataGridResult;

    }
}
