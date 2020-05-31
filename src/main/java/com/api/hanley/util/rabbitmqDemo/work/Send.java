package com.api.hanley.util.rabbitmqDemo.work;

import com.api.hanley.util.rabbitmqDemo.ConnectionRabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

    /**
     *   work模式
     *                          |----C1
     *   P-------- Queue -------|
     *                          |----C2
     *
     *
     * 1、现象
     * 消费者1和消费者2处理的消息数量是一样的
     * 消费者1奇数
     * 消费者1偶数
     * 这种方式叫轮询分发（round-robin）结果是不管谁忙谁闲，都不会多给一个消息，任务消息总是你一个我一个
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

        for (int i = 0; i < 50; i++) {
            String msg= "hello i:"+i;
            System.out.println("发消息："+msg);
            channel.basicPublish("",WORK_QUEUE,null,msg.getBytes());

            Thread.sleep(i*20);
        }

        channel.close();
        connection.close();
    }
}
