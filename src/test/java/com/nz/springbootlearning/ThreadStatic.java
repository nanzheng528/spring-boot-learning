package com.nz.springbootlearning;

public class ThreadStatic implements Runnable{
    private  static int num ;
    @Override
    public void run() {
        num = 3;
        System.out.println("当前线程是： " + Thread.currentThread().getName() + "num的值为：" + num);
        num = 5;
        System.out.println("当前线程是： " + Thread.currentThread().getName() + "num的值为：" + num * 2);
   /*     try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    public static void main(String[] args) {
        ThreadStatic threadStatic = new ThreadStatic();
        for (int i = 0; i< 1000 ; i++){
        new Thread(threadStatic,"thread---"+i+"----  ").start();
        }
    }
}
