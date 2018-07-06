package com.nz.springbootlearning;

import org.junit.Test;

public class ReferencePkValue {

    private  static  int number1 = 100;
    @Test
    public void ReferencePkValue111(){
        int value = 99;
        test1(value);
        System.out.println(value);
        myObj myObj = new myObj();
        test2(myObj);
        System.out.println(myObj.getB());
        ReferencePkValue referencePkValue = new ReferencePkValue();
        referencePkValue.number1++;
        System.out.println(referencePkValue.number1);
        ReferencePkValue referencePkValue2 = new ReferencePkValue();
        System.out.println(referencePkValue2.number1);
    }
    //我debug的时候传进来的a=101 after a+=1  a =104 ,正常运行的时候a=99 after a+=1  a=100，why
    public  static void test1(int value){
        number1++;
        System.out.println("初始化方法 a aa=" + value  );
        int a ;
        a = value++;
        System.out.println(a);
        System.out.println(value);
    }
    public  void test2(myObj obj){
        obj.b=100;
        System.out.println(obj.b);
    }
    private  class  myObj{
        private  int b ;

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
}
