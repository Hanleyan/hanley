package com.api.hanley.util.rabbitmqDemo.ps;

import com.api.hanley.util.rabbitmqDemo.ConnectionRabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    /**
     *   订阅发布模式ps(publish_subscribe)
     *   在消费者返回确认消息之前，只分发一个消息
     *
     *
     *                         |Queue -----------C1
     *   P------Exchange------ |
     *                         |Queue ----------C2
     *
     * routingKey:type="fanout"
     * 解读：
     * 1、一个生产者 多个消费者
     * 2、每一个消费者都有自己的队列
     * 3、生产者没有直接把消息发送到队列，而是发送到了交换机/转换器exchange
     * 4、每个队列都要绑定到交换机上
     * 5、生产者发送的消息 经过交换机 到达队列 就能实现一个消息被多个消费者消费
     *
     */
    protected static final String EXCHANGE_NAME="test_exchange_fanout";

    public static void main(String[] args) throws Exception{
        //连接rabbitmq
        Connection connection = ConnectionRabbitMqUtil.getConnection();

        //创建通道
        Channel channel = connection.createChannel();

        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");//分发

        for (int i = 0; i < 5; i++) {
            String msg= "hello 订阅发布模式 交换机 "+i;

            //发送消息
            channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());

            System.out.println("发消息："+msg);
        }


        channel.close();
        connection.close();
    }
}
