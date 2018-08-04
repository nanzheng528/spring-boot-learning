package com.nz.springbootlearning.Thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 下午 5:08 18/8/3
 * @ Description：线程回调
 * @ Modified By：
 * @Version: $
 */
public class CallableAndFuture {

    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>(){

            @Override
            public Integer call() throws Exception {
                return (int) (Math.random()*100);
            }
        };
        FutureTask<Integer> integerFutureTask = new FutureTask<>(callable);
        new Thread(integerFutureTask).start();

        try {
            Thread.sleep(0);
            System.out.println(integerFutureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
