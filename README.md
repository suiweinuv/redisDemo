# maven项目，非springboot
jedis客户端

# jedis客户端
1.pom文件引入依赖
2.建立连接（jedisTest.java）
3.操作数据库（jedisTest.java）,方法名与redis命令一致
4.释放资源

# jedis连接池
# jedis本身是线程不安全的，并且频繁的创建和销毁连接会有性能损耗，因此推荐使用jedis连接池替代直连方式
1.创建连接池（JedisConnectionFactory）
2.通过连接池活的连接

# springdataredis
新master
