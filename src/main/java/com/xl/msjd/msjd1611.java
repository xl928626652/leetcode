package com.xl.msjd;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1611 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{k * longer};
        int sum = k * longer;
        int[] res = new int[k + 1];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = sum;
            sum = sum - longer + shorter;
        }
        return res;
    }
}
