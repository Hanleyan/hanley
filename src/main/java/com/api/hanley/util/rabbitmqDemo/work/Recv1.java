package com.api.hanley.util.rabbitmqDemo.work;

import com.api.hanley.util.rabbitmqDemo.ConnectionRabbitMqUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Recv1 {

    //private static final String WORK_QUEUE="test_work_queue";

    public static void main(String[] args)  throws Exception{

        //连接rabbitmq
        Connection connection = ConnectionRabbitMqUtil.getConnection();

        //创建通道
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare(Send.WORK_QUEUE,false,false,false,null);


        //定义一个消费者
        Consumer consumer = new DefaultConsumer(channel){
            //消息到达 触发此方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body,"utf8");
                System.out.println("来消息了： "+msg);

                try{
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        };
        boolean autoAck = true;
        channel.basicConsume(Send.WORK_QUEUE,autoAck,consumer);

    }
}
