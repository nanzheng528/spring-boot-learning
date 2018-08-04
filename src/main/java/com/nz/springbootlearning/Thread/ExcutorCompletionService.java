package com.nz.springbootlearning.Thread;

import io.swagger.models.auth.In;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 下午 6:58 18/8/3
 * @ Description：创建多个返回值的任务
 * @ Modified By：
 * @Version: $
 */
public class ExcutorCompletionService {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> FutureList = new LinkedList<>();
        for (int i = 0; i <5 ; i++) {
            int finalI = i;
            Future<Integer> submit = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return finalI;
                }
            });
            FutureList.add(submit);
        }
        ExecutorCompletionService<Integer> integerExecutorCompletionService = new ExecutorCompletionService<Integer>(executorService);
        for (int i = 1; i < 5; i++){
            int taskID = i;
             integerExecutorCompletionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return taskID;
                }
            });
        }

        for (int i = 1; i < 5; i++) {
            try {
                System.out.println(integerExecutorCompletionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
                for (Future<Integer> integerFuture : FutureList) {
                    try {
                        System.out.println(integerFuture.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }

    }
}
