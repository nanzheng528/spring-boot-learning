package com.nz.springbootlearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 上午 10:56 18/7/5
 * @ Description：ActiveMq生产者
 * @ Modified By：
 * @Version: $
 */
@Service("producer")
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate; //也可以注入JmsTemplate ，jmsMessageingTemplate是对JmsTemplate的封装

    public void sendMessage(Destination destination,final String message){
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

}
