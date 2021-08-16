package com.xl.lc;

/**
 * @ClassName : lc1067
 * @Author : Xulian
 * @Date : 2020/12/3 14:42
 */
public class lc1067 {
    //Math.pow是真的挺耗时的。。 1ms，用digit累乘快很多
    public int digitsCount(int d, int low, int high) {
        return computeNums(d, high) - computeNums(d, low - 1);
    }

    public int computeNums(int d, int num) {
        String n = Integer.toString(num);
        int high = num / 10, low = 0, cur = num % 10;
        int res = 0;
        for (int i = 1; i <= n.length(); i++) {
            if (cur > d) {
                if (d == 0) res += (high) * Math.pow(10, i - 1);
                else res += (high + 1) * Math.pow(10, i - 1);
            } else if (cur == d) {
                if (d == 0) res += (high - 1) * Math.pow(10, i - 1) + low + 1;
                else res += high * Math.pow(10, i - 1) + low + 1;
            } else {
                res += high * Math.pow(10, i - 1);
            }
            low += cur * (int) Math.pow(10, i - 1);
            cur = high % 10;
            high /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int low = 1, high = 13;
        int res = new lc1067().digitsCount(1, low, high);
        System.out.println(res);
    }
}
