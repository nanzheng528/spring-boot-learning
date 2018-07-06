package com.nz.springbootlearning;

public class atomic implements Runnable{
    private  static  int i = 0;

    public  synchronized void inc(){
        i++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++){
            inc();
//            System.out.println("当前thread：" + Thread.currentThread().getName() + " i = " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        atomic atomic = new atomic();
        Thread[] threads = new Thread[100];
        for (int i = 0; i< 100 ;i++){
           threads[i] = new Thread( new atomic(),"thread"+i+"----- ");
           threads[i].start();
        }
        for (int i = 0;i<100;i++){
            threads[i].join();
        }
        System.out.println(atomic.i);
    }
}
