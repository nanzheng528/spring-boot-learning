package com.nz.springbootlearning.enumlearn;

public class SeasonSwitch {


    public static void main(String[] args) {

        Season summer = Season.WINTER;

        switch (summer){
            case FALL:
                System.out.println("秋高气爽");
                break;
            case SPRING:
                System.out.println("万物复苏");
                break;
            case SUMMER:
                System.out.println("烈日炎炎");
                break;
            case WINTER:
                System.out.println("银装素裹");
                break;
        }

        for (Season season : Season.values()){
            Season season1 = Season.valueOf("春");
            season1.getSeason();
            System.out.println(season.getSeason());
        }

    }

}
