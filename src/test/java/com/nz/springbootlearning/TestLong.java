package com.nz.springbootlearning;

/**
 * @ Author     ：nz.
 * @ Date       ：Created in 下午 5:38 18/7/9
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
public class TestLong {

    private static Long long1 = 12L;
    private static long long2 = 5L;

    public static void main(String[] args) {
        System.out.println(long1 + long2);
        System.out.println(-1L ^(-1L << 12L));
        System.out.println(1 << 12);
    }

}
