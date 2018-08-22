package com.nz.springbootlearning.designpattern.strategy;

public class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
