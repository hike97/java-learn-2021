package rabbitmq.$03_ack;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import rabbitmq.uitls.RabbitMqUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author hike97
 * @create 2021-09-27 12:58
 * @desc
 **/
public class AckWorkerDemo2 {
    private static final String ACK_QUEUE_NAME = "ack_queue";

    public static void main (String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel ();
        System.out.println ("C2 等待接收消息处理时间较长");
        //消息消费的时候如何处理消息
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String (delivery.getBody ());
            try {
                TimeUnit.SECONDS.sleep (30);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            System.out.println ("接收到消息:" + message);
            /**
             * 1.消息标记 tag
             * 2.是否批量应答未应答消息
             */
            channel.basicAck (delivery.getEnvelope ().getDeliveryTag (), false);
        };
        //设置不公平分发
        //        int prefetchCount = 1;
        int prefetchCount = 5;
        channel.basicQos (prefetchCount);
        //采用手动应答
        boolean autoAck = false;
        channel.basicConsume (ACK_QUEUE_NAME, autoAck, deliverCallback, (consumerTag) -> {
            System.out.println (consumerTag + "消费者取消消费接口回调逻辑");
        });
    }
}
