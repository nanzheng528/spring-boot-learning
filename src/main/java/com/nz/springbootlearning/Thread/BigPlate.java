package com.nz.springbootlearning.Thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BigPlate {


    /**定义一个装鸡蛋的盘子，大小为5*/
    private BlockingQueue plate = new ArrayBlockingQueue(5);

    //放鸡蛋
    public void putEgg(Object egg){
        try {
            //向盘子末尾放一个鸡蛋，如果盘子满了，当前线程阻塞
            plate.put(egg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("放入鸡蛋");

    }

    //取鸡蛋
    public Object getEgg(){
        Object egg = null;

        try {
            egg = plate.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("拿到了鸡蛋");
        return egg;
    }
    //添加的线程
    static class AddThread extends Thread{
        private BigPlate plate;
        private Object egg = new Object();
        public AddThread(BigPlate plate){
            this.plate = plate;
        }

        @Override
        public void run() {
            plate.putEgg(egg);
        }
    }
    //取出的线程
    static class GetThread extends Thread{
        private BigPlate plate;
        private Object egg = new Object();
        public GetThread(BigPlate plate){
            this.plate = plate;
        }

        @Override
        public void run() {
            plate.getEgg();
        }
    }

    public static void main(String[] args) {
        BigPlate bigPlate = new BigPlate();
        //先启动十个线程放入鸡蛋
        for (int i = 0; i < 10 ; i++){
            new Thread(new AddThread(bigPlate)).start();
        }
        //再启动十个线程拿到鸡蛋
        for (int i = 0; i < 10 ; i++){
            new Thread(new GetThread(bigPlate)).start();
        }
    }
}
