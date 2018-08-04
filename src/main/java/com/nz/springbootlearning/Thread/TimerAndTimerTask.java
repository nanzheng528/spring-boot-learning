package com.nz.springbootlearning.Thread;

import javax.rmi.CORBA.Tie;
import java.sql.Time;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 上午 11:36 18/8/3
 * @ Description：时间任务调度类
 * @ Modified By：
 * @Version: $
 */
public class TimerAndTimerTask {
    static class MyTimerTask1 extends TimerTask{
        @Override
        public void run() {
            System.out.println("爆炸1");
            new Timer().schedule(new MyTimerTask2(),2000 );
        }
    }
    static class MyTimerTask2 extends TimerTask{
        @Override
        public void run() {
            System.out.println("爆炸2");
            new Timer().schedule(new MyTimerTask1(), 3000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask2(), 2000);
        while (true){
            System.out.println(new Date().getSeconds());
            Thread.sleep(1000);
        }
    }
}
