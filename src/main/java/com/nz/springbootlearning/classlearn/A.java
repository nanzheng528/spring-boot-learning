package com.nz.springbootlearning.classlearn;

public class A {
}

class B extends A{

}

class c{
    static void test(Object x){
        print("Testing x of type" + x.getClass());
        print("x instance of A" + (x instanceof A));
        print("x instance of B" + (x instanceof B));
        print("A.isInstance(x)" + A.class.isInstance(x));
        print("B.insinstance(x)" + B.class.isInstance(x));
        print("x.getClass() == A.class" + (x.getClass() == A.class));
        print("x.getClass() == B.class" + (x.getClass() == B.class));
        print("x.getClass().equals(A.class)" + (x.getClass().equals(A.class)));
        print("x.getClass().equals(B.class)" + (x.getClass().equals(B.class)));

    }
    static void print(Object o){
        System.out.println(o);
    }

    public static void main(String[] args) {
        test(new A());
        test(new B());
    }
}