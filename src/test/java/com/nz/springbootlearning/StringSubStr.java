package com.nz.springbootlearning;

public class StringSubStr {
    public static void main(String[] args) {
        String a = "abcdefghijk";
        System.out.println(a.substring(5,a.length()-1));//[)从0开始，包括左边，不包括右边
    }
}
