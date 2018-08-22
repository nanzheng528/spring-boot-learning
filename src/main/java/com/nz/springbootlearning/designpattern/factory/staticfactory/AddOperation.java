package com.nz.springbootlearning.designpattern.factory.staticfactory;

import com.nz.springbootlearning.enumlearn.Operation;

public class AddOperation extends Opration {
    @Override
    public double getResult() {
        return numA + numB;
    }
}
