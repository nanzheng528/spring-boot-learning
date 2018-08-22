package com.nz.springbootlearning.designpattern.factory.staticfactory;

public class MulOperation extends  Opration {
    @Override
    public double getResult() {
        return numA * numB;
    }
}
