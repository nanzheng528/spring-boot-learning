package com.nz.springbootlearning.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 下午 1:39 18/8/3
 * @ Description：线程池
 * @ Modified By：
 * @Version: $
 */
public class ThreadPoolExcutor {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 5; i++){
            final int taskID = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i<5; i++){
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("第"+ taskID + "个任务的第" + i + "次执行");
                    }
                }
            });
        };
        threadPool.shutdown();

    }
}
