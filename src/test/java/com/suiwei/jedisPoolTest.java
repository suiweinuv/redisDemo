package com.suiwei;

import com.suiwei.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @author suiwei
 * @date 2022-08-10 13:18
 */

public class jedisPoolTest {
    private Jedis jedis;

    @BeforeEach//表示应在当前类中的每个@Test方法之前执行注解方法。
    void setUp() {//setup主要实现测试前的初始化工作
        jedis = JedisConnectionFactory.getJedis();
        jedis.auth("Suiwei123!");//redis设置的密码
        jedis.select(0);//选择数据库
    }
    @Test
    void  test(){
        String result = jedis.set("key01","val01");
        System.out.println(result);
        String result1 = jedis.get("key01");
        System.out.println(result1);
    }

    @Test
    void testhash() {
        jedis.hset("key02","name","suiwei");
        jedis.hset("key02","name","suiwei1");
        jedis.hset("key02","age","12");
        System.out.println(jedis.hget("key02","name"));
        Map map =  jedis.hgetAll("key02");
        System.out.println(map);

    }

    @AfterEach//表示应在当前类中的每个@Test方法之后执行注解方法
    void tearDown() {
        if (jedis!=null){
            jedis.close();
        }
    }


}
