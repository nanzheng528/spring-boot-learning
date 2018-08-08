package com.nz.test;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 上午 8:54 18/8/7
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class privateClass {

    protected String a;
    private String b ;
    public String c;
    String d;

}

class a {
    public static void main(String[] args) {
        privateClass privateClass = new privateClass();
        String a = privateClass.a;

    }
}