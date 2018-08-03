package com.nz.springbootlearning.Thread;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 上午 9:45 18/8/3
 * @ Description：线程让步
 * @ Modified By：
 * @Version: $
 */
public class ThreadYeild {

    public static void main(String[] args) {
        YieldThread t1 = new YieldThread("t1");
        Thread t2= new YieldThread("t2");
        t1.start();
        t2.start();
        try {
            //主线程睡1s
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        t2.interrupt();
    }


}

class YieldThread extends Thread{
    int i = 0;

    public YieldThread(String name) {
        super(name);
    }

    @Override
    public void run() {

            while (!isInterrupted()) {
                if (i<100) {
                System.out.println(getName() + "执行了" + ++i + "次");
                if (i % 10 == 0) {
                    Thread.yield();
                }
            }
        }
    }
}
