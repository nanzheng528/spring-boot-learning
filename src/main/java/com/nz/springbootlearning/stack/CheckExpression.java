package com.nz.springbootlearning.stack;

import java.util.LinkedList;

public class CheckExpression {
        public static String isValid(String expstr){
            //创建栈
            LinkedList<String> linkedList = new LinkedList();

            int i = 0;
            while (i <expstr.length() ){
                char c = expstr.charAt(i);
                i++;
                switch (c){
                    case '(':linkedList.add(c+"");break;
                    case ')':if (linkedList.size() == 0 || !linkedList.pop().equals("(")){
                        return "(";
                    }
                }
            }
            //最后检测是否为空，为空则检测通过
            if (linkedList.isEmpty()){
                return "check pass";
            } else {
                return "check exception";
            }
        }

    public static void main(String[] args) {
        String expstr="((5-3)*8-2)";
        System.out.println(expstr+"  "+isValid(expstr));
    }


}
