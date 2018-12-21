package com.taotao.controller;

import com.taotao.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String querytime(){

        return testService.queryNow();

    }

}
