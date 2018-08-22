package com.nz.springbootlearning.designpattern.strategy;

public class CashTest {
    public static void main(String[] args) {
        double money = 500;
        CashContext cashContext = null;
        cashContext = new CashContext(new CashNormal());
        double result = cashContext.getResult(money);
        System.out.println("正常付款的金额是：" + result);
        cashContext = new CashContext(new CashRebate(0.8));
        double resultRebate = cashContext.getResult(money);
        System.out.println("打八折的钱的金额是：" + resultRebate);
        cashContext = new CashContext(new CashReturn(50, 20));
        double resultReturn = cashContext.getResult(money);
        System.out.println("满五十减二十的金额是：" + resultReturn);

    }
}
