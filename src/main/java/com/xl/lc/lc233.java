package com.xl.lc;

/**
 * @ClassName : lc233
 * @Author : Xulian
 * @Date : 2020/12/3 19:36
 */
public class lc233 {
    //这道题是真的经典 lc 1067 是升级版本
    public int countDigitOne(int n) {
        int high = n / 10, low = 0, cur = n % 10, res = 0, digit = 1;
        int len = Integer.toString(n).length();
        for (int i = 1; i <= len; i++) {
            if (cur < 1) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            digit *= 10;
            cur = high % 10;
            high /= 10;
        }
        return res;
    }
}
