package com.nz.springbootlearning.Singleton;


/**
 * create by: nz
 * description: 饿汉式单例
 * create time: 上午 9:50 18/8/8
 *
 * @param null
 * @return
 */

public class SingletonHungry {

    private static SingletonHungry singletonHungry = new SingletonHungry();

    private SingletonHungry() {

    }

    private SingletonHungry getInstance() {
        return singletonHungry;
    }
}
