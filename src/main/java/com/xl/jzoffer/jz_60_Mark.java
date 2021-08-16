package com.xl.jzoffer;

import java.util.Arrays;

public class jz_60_Mark {
    public double[] twoSum(int n) {
        double[] pre = new double[6];
        Arrays.fill(pre, 1 / 6d);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < pre.length; j++) {
                for (int x = 0; x < 6; x++) {
                    tmp[j + x] += pre[j] * 1 / 6d;
                }
            }
            pre = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new jz_60_Mark().twoSum(2)));
        ;
    }
}
