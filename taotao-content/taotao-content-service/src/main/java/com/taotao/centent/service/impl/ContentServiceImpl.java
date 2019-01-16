package com.taotao.centent.service.impl;

import com.mysql.jdbc.StringUtils;
import com.taotao.centent.service.ContentService;
import com.taotao.content.jedis.JedisClient;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.util.JsonUtils;
import com.taotao.util.TaotaoResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author apple
 * @version V1.0
 * @className ContentServiceImpl
 * @Description
 * @date 2019/1/10 上午10:28
 */
@Service
public class ContentServiceImpl implements ContentService {

    private static Logger logger = LoggerFactory.getLogger(ContentServiceImpl.class.getName());
    @Value("${Content_Key}")
    String content_Key;

    @Autowired
    private JedisClient client;
    @Autowired
    private TbContentMapper contentMapper;
    @Override
    public TaotaoResult saveContent(TbContent tbContent) {
        tbContent.setCreated(new Date());
        tbContent.setUpdated(tbContent.getCreated());
        contentMapper.insertSelective(tbContent);

        try {
            client.hdel(content_Key,tbContent.getCategoryId()+"");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return TaotaoResult.ok();
    }

    @Override
    public List<TbContent> getContentByCatId(Long id) {
        List<TbContent> tbContents =null;
        String hget = client.hget(content_Key, id + "");
        if(!StringUtils.isNullOrEmpty(hget)){
            System.out.println("缓存已经生成");
            logger.info("缓存以及生成");
            return JsonUtils.jsonToList(hget,TbContent.class);
        }
        else {
            TbContentExample tbContentExample = new TbContentExample();
            TbContentExample.Criteria criteria = tbContentExample.createCriteria();
            TbContentExample.Criteria criteria1 = criteria.andCategoryIdEqualTo(id);
            tbContents = contentMapper.selectByExampleWithBLOBs(tbContentExample);

            try {
                client.hset(content_Key, id + "", JsonUtils.objectToJson(tbContents));
            } catch (Exception e) {

                e.printStackTrace();
                logger.error("redis error:" + e);
            }
        }
        return tbContents;
    }
}
