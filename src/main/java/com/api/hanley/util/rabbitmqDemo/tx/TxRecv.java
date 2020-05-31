package com.api.hanley.util.rabbitmqDemo.tx;

import com.api.hanley.util.rabbitmqDemo.ConnectionRabbitMqUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author hanley
 * @date 2019/5/17 17:23
 * 风萧萧兮易水寒
 */
public class TxRecv {

    /**
     * 1.13.6.消费者从队列中获取消息
     */

    public static void main(String[] args)throws Exception {
        //获取连接以及mq通道
        Connection connection = ConnectionRabbitMqUtil.getConnection();
        //从连接中获取通道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(TxSend.QUEUE_NAME,false,false,false,null);
        //监听队列 新版本
        channel.basicConsume(TxSend.QUEUE_NAME,true,new DefaultConsumer(channel){
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String routingKey = envelope.getRoutingKey();
                long deliveryTag = envelope.getDeliveryTag();
                System.out.println("routingKey:" + routingKey + ",deliveryTag:" + deliveryTag);
                System.out.println("----msg------" + new String(body, "UTF-8"));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 消息确认
                /**
                 * deliveryTag:该消息的index
                 * multiple：是否批量.true:将一次性ack所有小于deliveryTag的消息
                 */
                channel.basicAck(deliveryTag, false);
            }
        });

    }
}
