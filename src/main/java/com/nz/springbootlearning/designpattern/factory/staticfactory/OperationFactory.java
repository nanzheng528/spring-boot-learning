package com.nz.springbootlearning.designpattern.factory.staticfactory;

public class OperationFactory {

    public static Opration createOperation(String operate){
        Opration opration = null;
        if (operate == null) {
            throw  new IllegalArgumentException("运算符不能为空！");
        } else if ("+".equals(operate)){
            opration = new AddOperation();
        } else if ("-".equals(operate)){
            opration = new SubOperation();
        } else if ("*".equals(operate)){
            opration = new MulOperation();
        } else if ("/".equals(operate)){
            opration = new DivOperation();
        } else {
            throw new IllegalArgumentException("无效的运算符");
        }
        return opration;
    }
}
