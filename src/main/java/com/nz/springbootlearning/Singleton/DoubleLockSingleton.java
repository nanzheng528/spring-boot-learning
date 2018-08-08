package com.nz.springbootlearning.Singleton;

public class DoubleLockSingleton {

    private static  volatile DoubleLockSingleton doubleLockSingleton;

    private DoubleLockSingleton(){}

    private static DoubleLockSingleton doubleLockSingleton(){
        if (doubleLockSingleton == null){ //判断实例是否为null，多线程中可能同时进入这条语句
            synchronized (DoubleLockSingleton.class){ //将类锁住
                if (doubleLockSingleton == null) { //第二次判断是否为空，因为第一次判断为空时，可能有好多线程得到的doubleLockSingltoh都是空的,不判断直接生成实例的话就会生成好多对象
                    doubleLockSingleton = new DoubleLockSingleton(); //如果不加voliatle关键字，这里可能由于指令重排序得到半个对象：分配了内存，但还没有初始化。
                }
            }

        }
        return doubleLockSingleton;
    }

}
