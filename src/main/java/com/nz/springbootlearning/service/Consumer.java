package com.nz.springbootlearning.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 上午 11:37 18/7/5
 * @ Description：ActiveMQ消费者
 * @ Modified By：
 * @Version: $
 */
@Component
public class Consumer {
    //Jms配置消费者监听器，text是收到的消息
    @JmsListener(destination = "test.queue")
    public void receiveQueue (String text){
        System.out.println("Consumer收到的消息是：" + text);
    }
}
