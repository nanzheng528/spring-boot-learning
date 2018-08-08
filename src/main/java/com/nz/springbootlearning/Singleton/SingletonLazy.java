package com.nz.springbootlearning.Singleton;

public class SingletonLazy {

    private static volatile SingletonLazy singletonLazy;

    private SingletonLazy(){}

    public SingletonLazy getSingletonLazyInstance(){

        if (null == singletonLazy){
            singletonLazy = new SingletonLazy();
        }

        return singletonLazy;

    }
}
