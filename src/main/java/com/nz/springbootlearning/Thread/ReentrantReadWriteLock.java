package com.nz.springbootlearning.Thread;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 上午 10:14 18/8/4
 * @ Description：可重入读写锁
 * @ Modified By：
 * @Version: $
 */
public class ReentrantReadWriteLock {

    private  int data ;
    private ReadWriteLock rwl = new java.util.concurrent.locks.ReentrantReadWriteLock();
    public void setData(int data){
        rwl.writeLock().lock();//加锁
        try {
            System.out.println(Thread.currentThread().getName() + "准备写入数据");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = data;
            System.out.println(Thread.currentThread().getName() + "写入" + this.data);
        }finally {
            rwl.writeLock().unlock();
        }
    }

    public void getData() {
        rwl.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "准备开始读数据");

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "读取到的数据为" + this.data);
        }finally {
            rwl.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        for (int i = 0; i < 3 ; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    reentrantReadWriteLock.setData(new Random().nextInt(100));
                }
            }).start();
        }
        for (int i = 0; i < 3 ; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    reentrantReadWriteLock.getData();
                }
            }).start();
        }

    }

}
