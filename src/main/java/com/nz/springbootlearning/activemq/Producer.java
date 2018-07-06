package com.nz.springbootlearning.activemq;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Date;

public class Producer {
    public static void main(String[] args) throws JMSException {
        String tcpUrl = "tcp://127.0.0.1:61616";
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin", "admin", tcpUrl);
        Connection connection = activeMQConnectionFactory.createConnection();
        try {
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue1 = session.createQueue("queue1");
            MessageProducer producer = session.createProducer(queue1);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("发送时间"+new Date());
            producer.send(textMessage);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
                if (connection != null){
                    connection.close();
                }
        }

    }
}
