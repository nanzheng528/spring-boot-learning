package com.nz.springbootlearning.reflection;

import java.lang.reflect.Array;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 上午 10:22 18/7/10
 * @ Description：数组的反射
 * @ Modified By：
 * @Version: $
 */
public class ReflectionArray {

    private static Array array;


    public static void main(String[] args) {
        int [] intsArray = (int[]) Array.newInstance(int.class, 3);
        Array.set(intsArray, 0, 1);
        Array.set(intsArray, 1, 2);
        Array.set(intsArray, 2, 3);
        System.out.println(array);
        System.out.println(Thread.currentThread().getName()+"intArray[] :" + Array.get(intsArray, 0));
        System.out.println(Thread.currentThread().getName()+"intArray[] :" + Array.get(intsArray, 1));
        System.out.println(Thread.currentThread().getName()+"intArray[] :" + Array.get(intsArray, 2));
    }


}
