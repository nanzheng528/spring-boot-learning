package com.nz.springbootlearning;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private  static final SimpleDateFormat dateFormate = new SimpleDateFormat("HH:mm:ss");
   /* @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("now time"+dateFormate.format(new Date()));
    }*/
}
