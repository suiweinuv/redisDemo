package com.suiwei.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author suiwei
 * @date 2022-08-10 16:02
 */
public class JedisConnectionFactory {
    private static final JedisPool jedisPool;
    static {
        //配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //最大连接数
        poolConfig.setMaxTotal(8);
        //最大空闲连接
        poolConfig.setMaxIdle(6);
        //最小空闲连接，一段时间没有链接，连接数会慢慢减少到0
        poolConfig.setMinIdle(0);
        //等待多长时间，空闲时间才会被释放
        poolConfig.setMaxWaitMillis(1000);
        //创建连接池对象
        jedisPool = new JedisPool(poolConfig,"124.70.29.109",6379,1000,"Suiwei123!");
    }
    public static Jedis getJedis(){
        return  jedisPool.getResource();
    }
}
