package com.nz.springbootlearning;

import com.nz.springbootlearning.controller.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootLearningApplicationTests {
   @Autowired
   private Task task;
    @Test
    public void contextLoads() {
    }

}
