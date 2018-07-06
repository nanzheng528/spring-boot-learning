package com.nz.springbootlearning.Current;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 上午 8:49 18/7/5
 * @ Description：CAS算法
 * @ Modified By：
 * @Version: $
 */
public class CompareAndSwap {
    private int value;

    public synchronized int getValue(){
        return this.value;
    }

    public  synchronized int compareAndSwap(int expectValue,int newValue){
        int oldValue = this.value;
        if (oldValue == expectValue){
            this.value = newValue;
        }
        return oldValue;
    }
    public synchronized boolean compareAndSet(int expectValue, int newValue){
        return  expectValue == compareAndSwap(expectValue, newValue);
    }

    public static void main(String[] args) {
        CompareAndSwap compareAndSwap = new CompareAndSwap();
        for (int i = 0; i < 10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int expectValue = compareAndSwap.getValue();
                    boolean b = compareAndSwap.compareAndSet(expectValue, (int) (Math.random()*100));
                    System.out.println(b);
                }
            }).start();
        }
    }
}
