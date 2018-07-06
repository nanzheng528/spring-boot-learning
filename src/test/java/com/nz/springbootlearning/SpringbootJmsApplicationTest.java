package com.nz.springbootlearning;

import com.nz.springbootlearning.service.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 上午 11:42 18/7/5
 * @ Description：ActiveMQ测试
 * @ Modified By：
 * @Version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJmsApplicationTest {
        @Autowired
        private Producer producer;
        @Test
        public  void   contextLoads(){
            Destination destination = new ActiveMQQueue("test.queue");

            for (int i = 0; i<100;i++){
                producer.sendMessage(destination, "hello you ");
            }
        }
}
