package com.api.hanley.util.rabbitmqDemo.routing;

import com.api.hanley.util.rabbitmqDemo.ConnectionRabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    /**
     *   路由模式routing
     *
     *
     *
     *                              |Queue -----------C1
     *              --routingKey:error
     *   P------Exchange------      |
     *              --routingKey:error/info/warning
     *                             |Queue ----------C2
     *
     * Exchange:type="direct"
     * 消息发送的交换机，交换机根据消息的路由键发送到队列，队列可以有多个路由键的消息
     *
     */
    protected static final String EXCHANGE_NAME="test_exchange_direct";

    public static void main(String[] args) throws Exception{
        //连接rabbitmq
        Connection connection = ConnectionRabbitMqUtil.getConnection();

        //创建通道
        Channel channel = connection.createChannel();

        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"direct");//

        for (int i = 0; i < 1; i++) {
            String msg= "hello 路由模式routing "+i;

            //发送消息
            String routingKey="warning";//路由键
            channel.basicPublish(EXCHANGE_NAME,routingKey,null,msg.getBytes());
            System.out.println("发消息："+msg);
        }


        channel.close();
        connection.close();
    }
}
