package com.api.hanley.util.rabbitmqDemo.topic;

import com.api.hanley.util.rabbitmqDemo.ConnectionRabbitMqUtil;
import com.rabbitmq.client.*;

import java.io.IOException;


public class Recv1 {

    private static final String QUEUE_NAME="test_queue_topic_1";

    public static void main(String[] args)  throws Exception{

        //连接rabbitmq
        Connection connection = ConnectionRabbitMqUtil.getConnection();

        //创建通道
        Channel channel = connection.createChannel();

        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //绑定队列到交换机
        channel.queueBind(QUEUE_NAME,Send.EXCHANGE_NAME,"goods.add");

        channel.basicQos(1);//保证一次只分发一个

        //定义一个消费者
        Consumer consumer = new DefaultConsumer(channel){
            //消息到达 触发此方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body,"utf8");
                System.out.println("topic模式[1]来消息了： "+msg);

                try{
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    //每次处理完消息后返回确认消息
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }

            }
        };
        //关闭自动应答
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME,autoAck,consumer);

    }
}
