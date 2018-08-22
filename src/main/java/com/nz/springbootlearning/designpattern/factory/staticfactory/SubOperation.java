package com.nz.springbootlearning.designpattern.factory.staticfactory;

public class SubOperation extends Opration {


    @Override
    public double getResult() {
        return numA - numB;
    }
}
