package com.xl.msjd;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1607 {
//    public int maximum(int a, int b) {
//        return (int) ((Math.abs((long) a - (long) b) + (long) a + (long) b) / 2);
//    }
    public int maximum(int a, int b) {
        long x = (long) a - (long) b;
        int k = (int) (x >> 63);
        return (1 + k) * a - b * k;
    }

    public static void main(String[] args) {
//        new msjd1607().maximum(1,2);

    }


}
