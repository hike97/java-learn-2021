package com.bfxy.rocketmq.consumer.pull;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import com.bfxy.rocketmq.constants.Const;

public class Producer {
    public static void main (String[] args) throws MQClientException, InterruptedException {
        //定义groupName
        String group_name = "test_pull_producer_name";
        DefaultMQProducer producer = new DefaultMQProducer (group_name);
        producer.setNamesrvAddr (Const.NAMESRV_ADDR_SINGLE);
        producer.start ();

        for (int i = 0; i < 10; i++) {
            try {
                Message msg = new Message ("test_pull_topic",// topic 主题
                        "TagA",// tag 为了消息过滤
                        ("Hello RocketMQ " + i).getBytes ()// body
                );

                SendResult sendResult = producer.send (msg);
                System.out.println (sendResult);
                Thread.sleep (1000);
            } catch (Exception e) {
                e.printStackTrace ();
                Thread.sleep (3000);
            }
        }

        producer.shutdown ();
    }
}
