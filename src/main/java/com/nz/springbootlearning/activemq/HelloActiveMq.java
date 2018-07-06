package com.nz.springbootlearning.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 下午 4:41 18/7/4
 * @ Description：hello
 * @ Modified By：
 * @Version: 1.0$
 */
public class HelloActiveMq {
    public static void main(String[] args) {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        try {
            Connection connection = activeMQConnectionFactory.createConnection("admin","admin");
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            connection.start();
            Destination destination = session.createQueue   ("queue1");
            MessageProducer producer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("helloConsumer");
            producer.send(textMessage);
//            MessageConsumer consumer = session.createConsumer(destination);
//            consumer.receiveNoWait();
            Consumer(activeMQConnectionFactory,destination);
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
//        System.out.prin   tln(ActiveMQConnectionFactory.DEFAULT_USER);
//        System.out.println(ActiveMQConnectionFactory.DEFAULT_PASSWORD);
//        System.out.println(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
    }

    private static  void Consumer(ActiveMQConnectionFactory activeMQConnectionFactory,Destination destination) throws JMSException {
        Connection connection = activeMQConnectionFactory.createConnection("admin", "admin");
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        Destination destination = session.createQueue   ("queue1");
        MessageConsumer consumer = session.createConsumer(destination);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                if (message instanceof  TextMessage){
                    try {
                        System.out.println(message.getJMSDeliveryMode());
                        System.out.println(((TextMessage) message).getText());
                        message.acknowledge();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
//        consumer.receive();
//        System.out.println(consumer.receive());
        connection.close();

    }

}
