package com.nz.springbootlearning;

import com.nz.springbootlearning.controller.Task;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private Task task;
    @Test
    public void test() throws Exception {
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaskThree();
    }
}
