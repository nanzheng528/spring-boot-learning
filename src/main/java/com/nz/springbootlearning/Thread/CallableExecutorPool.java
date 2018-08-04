package com.nz.springbootlearning.Thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 下午 5:37 18/8/3
 * @ Description：线程池创建callable
 * @ Modified By：
 * @Version: $
 */
public class CallableExecutorPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> submit = executorService.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        });
        try {
            Thread.sleep(2000);
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
