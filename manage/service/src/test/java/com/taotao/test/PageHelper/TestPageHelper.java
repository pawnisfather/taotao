package com.taotao.test.PageHelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.List;

/**
 * @author apple
 * @version V1.0
 * @className TestPageHelper
 * @Description
 * @date 2018/12/21 下午2:16
 */

public class TestPageHelper {


    @Test
    public void testPageHelper() {


//        1.设置分页信息
        PageHelper.startPage(1, 3);


//        2。初始化spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");

//        3.获取mapper的代理对象
        TbItemMapper tbItemMapper = context.getBean(TbItemMapper.class);
//        4.调用mapper的方法查询数据
        TbItemExample tbItemExample = new TbItemExample();
        List<TbItem> tbItems = tbItemMapper.selectByExample(tbItemExample);

//        5.打印结果集
        PageInfo<TbItem> tbItemPageInfo = new PageInfo<>(tbItems);
        System.out.println(tbItemPageInfo.getSize());


        for (Iterator iterator=tbItemPageInfo.getList().iterator();iterator.hasNext();){
            System.out.println(iterator.next().toString());
        }




    }

}
