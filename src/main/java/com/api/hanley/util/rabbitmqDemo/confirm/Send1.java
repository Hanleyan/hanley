package com.api.hanley.util.rabbitmqDemo.confirm;

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
public class Send1 {

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
     * 2.confirm模式
     * 生产者将信道设置成confirm模式，一旦信道进入confirm模式，
     * 所有在该信道上面发布的消息都将会被指派一个唯一的ID(从1开始)，一旦消息被投递到所有匹配的队列之后，
     * broker就会发送一个确认给生产者(包含消息的唯一ID)，这就使得生产者知道消息已经正确到达目的队列了，
     * 如果消息和队列是可持久化的，那么确认消息会在将消息写入磁盘之后发出，
     * broker回传给生产者的确认消息中delivery-tag域包含了确认消息的序列号，
     * 此外broker也可以设置basic.ack的multiple域，表示到这个序列号之前的所有消息都已经得到了处理；
     *
     * confirm模式最大的好处是  异步
     * rabbitmq如果服务器异常或者崩溃，就会发送一个nack消息
     *
     * 开启confirm模式
     * channel.confirmSelect();
     *
     * 编程模式
     * 1.普通  发一条 waitForConfirms()
     * 2.批量  发一批 waitForConfirms()
     * 3.异步confirm模式  提供一个回调方法
     *
     * confirm模式 1.普通
     * 简单模式试例
     *
     */
    protected final static String QUEUE_NAME = "test_hanley_confirm1";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //获取连接以及mq通道
        Connection connection = ConnectionRabbitMqUtil.getConnection();
        //从连接中获取通道
        Channel channel = connection.createChannel();

        //声明（创建）队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        //生产者调用confirmSelect将channle设置成confirm模式
        channel.confirmSelect();

        //消息内容
        String msg = "HELLO WORLD confirm!2";

        //发布消息
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());

        //确认
        if(!channel.waitForConfirms()){
            System.out.println("send msg failed");
        }else{
            System.out.println("send msg success");
        }

        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
