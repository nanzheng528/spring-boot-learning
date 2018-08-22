package com.nz.springbootlearning.designpattern.factory.staticfactory;

public class DivOperation extends Opration{


    @Override
    public double getResult() {
        return numA / numB;
    }
}
