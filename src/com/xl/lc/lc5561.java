package com.xl.lc;

/**
 * @ClassName : lc5561
 * @Author : Xulian
 * @Date : 2020/11/8 15:49
 */
public class lc5561 {
    public int getMaximumGenerated(int n) {
        int[] res = new int[n + 1];
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        res[0] = 0;
        res[1] = 1;
        res[2] = 1;
        int max = 1;
        for (int i = 3; i < n + 1; i++) {
            if ((i % 2) == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i / 2] + res[i / 2 + 1];
            }
            max = Math.max(res[i], max);
        }
        return max;
    }
}
