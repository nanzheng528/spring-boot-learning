package com.nz.springbootlearning.designpattern.factory.staticfactory;

import java.util.Scanner;

public class OperationTest {
    public static void main(String[] args) {
        Opration opration = null;
        Scanner scanner = new Scanner(System.in);
        try {
            do {
                System.out.println("请输入数字A：");
                double numA = scanner.nextDouble();
                System.out.println("输入运算符（+/-/*//）:");
                String oprator = scanner.next();
                System.out.println("请输入数字B：");
                double numB = scanner.nextDouble();

                opration = OperationFactory.createOperation(oprator);
                opration.setNumA(numA);
                opration.setNumB(numB);

                double result = opration.getResult();
                System.out.println("运算结果为：" + result);
                System.out.println("是否要继续操作？：Y/N");

}while (scanner.next().equalsIgnoreCase("Y"));

        } catch (RuntimeException e){
        e.printStackTrace();
        }
        }
}
