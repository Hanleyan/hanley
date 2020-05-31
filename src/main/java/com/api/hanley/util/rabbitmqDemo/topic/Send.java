package com.api.hanley.util.rabbitmqDemo.topic;

import com.api.hanley.util.rabbitmqDemo.ConnectionRabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    /**
     *   通配符模式topic
     *
     *
     *
     *                              |Queue -----------C1
     *              --routingKey:goods.add
     *   P------Exchange------      |
     *              --routingKey:goods.#
     *                             |Queue ----------C2
     *
     * Exchange:type="topic"
     * 将路由与某模式进行匹配
     * #-------匹配一个或者多个 eg:goods.#  #.add
     * *--------匹配一个  eg:goods.*  *.add
     *
     */
    protected static final String EXCHANGE_NAME="test_exchange_topic";

    public static void main(String[] args) throws Exception{
        //连接rabbitmq
        Connection connection = ConnectionRabbitMqUtil.getConnection();

        //创建通道
        Channel channel = connection.createChannel();

        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"topic");//

        for (int i = 0; i < 1; i++) {
            String msg= "hello 路由模式routing "+i;

            //发送消息
            String routingKey="goods.add";//路由键
            channel.basicPublish(EXCHANGE_NAME,routingKey,null,msg.getBytes());
            System.out.println("发消息："+msg);
        }


        channel.close();
        connection.close();
    }
}
