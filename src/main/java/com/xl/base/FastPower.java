package com.xl.base;

import java.util.Arrays;

/**
 * @ClassName : FastPower
 * @Author : Xulian
 * @Date : 2021/1/7 19:52
 */
public class FastPower {
    //double要一开始定义成0.0d

    public double fastPower(double x, int n) {
        // Math.pow返回的是double类型
        //        double ans = Math.pow(x, n);
        if (x == 0.0d) return x;
        long b = n;
        if (n < 0) {
            b = -b;
            x = 1 / x;
        }
        double res = 1.0d;
        while (b != 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            b >>= 1;
            x *= x;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ab";
        StringBuilder sb = new StringBuilder("ab");
        Math.random();
        int[] k = new int[]{1, 23, 4, 5};

    }
}
