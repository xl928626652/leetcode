package com.xl.meituan;

/**
 * @ClassName : First
 * @Author : Xulian
 * @Date : 2021/4/6 19:22
 */
public class First {
    public static int trycatch() {
        try {
            int a = 1 / 0;
            System.out.println("tryhere");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catchhere");
            return 0;
        } finally {
            System.out.println("finallyhere");
            return 1;
        }
    }

    public static void main(String[] args) {
        int a = trycatch();
        System.out.println(a);
    }
}
