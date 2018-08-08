package com.nz.springbootlearning.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 下午 3:18 18/8/4
 * @ Description：Condition作用于不同的线程
 * @ Modified By：
 * @Version: $
 */
public class BoundedBuffer {

    final Lock lock = new ReentrantLock(); // 锁对象
    final Condition notFull = lock.newCondition(); //写线程条件
    final Condition notEmpty = lock.newCondition(); //读线程条件
    final Object[] items = new Object[100];
    int putptr /**写索引*/ , takeptr /**读索引*/,count;/**队列中存在的数据个数*/

    public void put(Object x){
        lock.lock();
        try {
            while (count == items.length-20){//如果队列满了
                notFull.await(); //阻塞写线程
            }
            items[putptr] = x; //赋值
            if (++putptr == items.length){ //如果put的满了的话 下次放入的索引就为0
                    putptr = 0; };
            count++;
            System.out.println("副线程放入了:" + x.toString()+"先在篮子里一共有"+count +"个鸡蛋");
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object take(){
        lock.lock();
        try {
            while (count == 0){
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object o =items[takeptr];
            if (takeptr++ == items.length){ takeptr = 0;}
            --count;
            notFull.signal();//唤醒写线程
            System.out.println("主线程拿走了:"+o.toString()+"先在篮子里一共有"+count+"个鸡蛋");
            return o;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BoundedBuffer boundedBuffer = new BoundedBuffer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadExecute(boundedBuffer, "put");
            }
        }).start();
        threadExecute(boundedBuffer,"take" );

    }
    public static void threadExecute(BoundedBuffer boundedBuffer,String threadType){
        for (int i = 0; i < 100; i++){
            if ("put".equals(threadType)){
                boundedBuffer.put(i);
            } else {
                boundedBuffer.take();
            }
        }
    }
}
