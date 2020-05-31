package com.api.hanley.util.rabbitmqDemo;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author hanley
 * @date 2019/5/17 16:46
 * 风萧萧兮易水寒
 */
public class ConnectionRabbitMqUtil {

    public static Connection getConnection() throws IOException,TimeoutException {
        //定义连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();

        //设置服务地址
        connectionFactory.setHost("127.0.0.1");
        //端口
        connectionFactory.setPort(5672);

        //设置账户信息
        connectionFactory.setVirtualHost("/vhost_hanley"); //virtual host 相当于rabbit的数据库
        connectionFactory.setUsername("hanley");
        connectionFactory.setPassword("hanley");

        //通过工厂获取连接
        Connection connection = connectionFactory.newConnection();
        return connection;
    }

    public static void main(String[] args) throws Exception{
        Connection connection = getConnection();
        System.out.println(connection);
    }
}
