package com.api.hanley.util.rabbitmqDemo.simple;

import com.api.hanley.util.rabbitmqDemo.ConnectionRabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author hanley
 * @date 2019/5/17 17:01
 * 风萧萧兮易水寒
 */
public class Send {

    /**
     *  简单模式
     *
     *  P-------- Queue -------C
     *
     */
    private final static String QUEUE_NAME = "test_hanley";

    public static void main(String[] args)throws Exception {
        //获取连接以及mq通道
        Connection connection = ConnectionRabbitMqUtil.getConnection();
        //从连接中获取通道
        Channel channel = connection.createChannel();

        //声明（创建）队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //消息内容

        String msg = "HELLO WORLD!";
        byte[] bytes = new byte[2014];

        //发布消息
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        System.out.println("[X] send '"+msg+"' ");

        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
