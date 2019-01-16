package com.taotao.jedis;

import com.taotao.content.jedis.JedisClient;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author apple
 * @version V1.0
 * @className TestJedis
 * @Description
 * @date 2019/1/14 下午4:04
 */

public class TestJedis {
    private static Logger logger = LoggerFactory.getLogger(TestJedis.class.getName());
    @Test
    public void testJedis(){
        Jedis jedis = new Jedis("47.106.117.14");
        jedis.set("a1111","b");
        System.out.println(jedis.get("a1111"));
        jedis.close();
    }

    public void testJedisPool(){
        JedisPool jedisPool = new JedisPool("47.106.117.14");
        Jedis resource = jedisPool.getResource();
//        resource.set()
    }

    @Test
    public void testJedisPollBySpring(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new
                ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
        JedisClient bean = classPathXmlApplicationContext.getBean(JedisClient.class);
        bean.set("first","100");
        String first = bean.get("first");
        System.out.println(first);


    }
}
