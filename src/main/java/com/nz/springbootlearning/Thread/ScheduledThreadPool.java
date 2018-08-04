package com.nz.springbootlearning.Thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 下午 4:28 18/8/3
 * @ Description：定时线程池任务
 * @ Modified By：
 * @Version: $
 */
public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("爆炸");
            }
        }, 2, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            int i = 0;
            @Override
            public void run() {
                System.out.println("爆炸了" + i +"次");
                i++;
            }
        }, 3, 2, TimeUnit.SECONDS);
    }
}
