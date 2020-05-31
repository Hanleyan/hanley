package com.api.hanley.util.rabbitmqDemo.tx;

import com.api.hanley.util.rabbitmqDemo.ConnectionRabbitMqUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author hanley
 * @date 2019/5/17 17:01
 * 风萧萧兮易水寒
 */
public class TxSend {

    /**
     * rabbitMQ的消息确认机制（事务+confirm）
     *
     * 在rabbitmq中，我们可以通过持久化数据，解决rabbitmq的服务器异常  的数据丢失问题
     * 问题：生产者检消息发送出去后，是否到达rabbitmq服务器？默认的情况下是不知道的
     *
     * 两种方式解决：
     * 1.AMQP  实现了事物机制 （弊端：这种模式比较耗时，降低了rabbitmq的吞吐量）
     * 2.confirm 模式
     *
     * 1.AMQP   事物机制
     * txSelect 用户将当前channel设置成transation模式
     * txCommit  用于提交事物
     * txRollback  回滚事物
     *
     * AMQP 简单模式试例
     *
     */
    protected final static String QUEUE_NAME = "test_hanley_tx";

    public static void main(String[] args) throws IOException,TimeoutException {
        //获取连接以及mq通道
        Connection connection = ConnectionRabbitMqUtil.getConnection();
        //从连接中获取通道
        Channel channel = connection.createChannel();

        //声明（创建）队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //消息内容
        String msg = "HELLO WORLD TX!";

        try {
            channel.txSelect();//开启事务
            //发布消息
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            int a = 1/0;
            System.out.println("[X] send '"+msg+"' ");
            channel.txCommit();//提交
        } catch (Exception e) {
            channel.txRollback();//回滚
            System.out.println("send message txRollback");
        }

        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
