package com.api.hanley.util.rabbitmqDemo.workfair;

import com.api.hanley.util.rabbitmqDemo.ConnectionRabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    /**
     *   work模式-公平分发
     *   在消费者返回确认消息之前，只分发一个消息
     *                          |----C1
     *   P-------- Queue -------|
     *                          |----C2
     *
     *
     * 消费者 1.确认每次只收到一个消息
     *       2.每次处理完消息要返回确认信息
     *       3.自动应答  关闭
     *
     */
    protected static final String WORK_QUEUE="test_work_queue";

    public static void main(String[] args) throws Exception{
        //连接rabbitmq
        Connection connection = ConnectionRabbitMqUtil.getConnection();

        //创建通道
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare(WORK_QUEUE,false,false,false,null);

        channel.basicQos(1);//保证一次只分发一个

        for (int i = 0; i < 50; i++) {
            String msg= "hello i:"+i;
            System.out.println("发消息："+msg);
            channel.basicPublish("",WORK_QUEUE,null,msg.getBytes());

            Thread.sleep(i*5);
        }

        channel.close();
        connection.close();
    }
}
