package com.nz.springbootlearning;

public class TestFor {
    static boolean foo(char c ){
        System.out.println(c);
        return true;
    }
    public static void main(String[] args) {
        int i = 0;
        for (foo('A'); foo('B')&&(i<2); foo('C')){  //1.定义变量2.判断是否为TRUE3.执行方法体4.执行后的变量修改
            i++;
            foo('D');
        }
    }
}
