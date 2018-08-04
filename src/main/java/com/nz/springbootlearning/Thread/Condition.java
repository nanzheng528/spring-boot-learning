package com.nz.springbootlearning.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 上午 10:36 18/8/4
 * @ Description：Condition来替代wait notify用来线程间的通信
 * @ Modified By：
 * @Version: $
 */
public class Condition {

     static class Businewss{
        private boolean bool = true;
        private Lock  lock = new ReentrantLock();
        private java.util.concurrent.locks.Condition condition = lock.newCondition();
        public void main(int loop){
            lock.lock();
            try {
                while (bool){
                    try {
                        condition.await();//相当于wait()方法
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 100; i++) {
                    System.out.println("main thread seq of " + i + ", loop of" + loop);
                }
                bool = true;
                condition.signal();//相当于notify();
            } finally {
                lock.unlock();
            }
        }
        public void sub(int loop) throws InterruptedException {
            lock.lock();
            try {
                while (!bool){
                    condition.await();
                }
                for (int i = 0; i < 100; i++){
                    System.out.println("sub thread seq of " + i + ",loop of " + loop);
                }
                bool = false;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        Businewss businewss = new Businewss();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadExecute(businewss, "sub");
            }
        }).start();
        threadExecute(businewss, "main");
    }

    public  static void threadExecute(Businewss businewss,String threadType){
        for (int i = 0; i < 100; i++){
            if ("main".equals(threadType)){
                businewss.main(i);
            } else {
                try {
                    businewss.sub(i);
                }    catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
