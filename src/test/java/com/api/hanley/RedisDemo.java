package com.api.hanley;


import redis.clients.jedis.Jedis;

/**
 * @author hanley
 * @date 2019/4/25 11:23
 * 风萧萧兮易水寒
 */
public class RedisDemo {

    public static void main(String[] args) {

        /*
            用到的jar
            <dependency>
                <groupId>redis.clients</groupId>
                <artifactId>jedis</artifactId>
                <version>2.9.0</version>
		    </dependency>

		    springBoot与redis连接有额外的包
        */

        /*Jedis jedis = new Jedis("39.106.151.178",6379);//创建连接redis的客户端 ip和端口  auth=123456
        //jedis.auth("123456");//连接的密码
        //jedis.set("phones","IphoneXR");//设置键值
        //String value = jedis.get("phone");
        boolean b = jedis.exists("phone");
        System.out.println(b);
        jedis.close(); //释放连接资源*/

        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("347.111.147.99",6379);
        jedis.auth("654321");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务器正在运行: "+jedis.ping());
    }
}
