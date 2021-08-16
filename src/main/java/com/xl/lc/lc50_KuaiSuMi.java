package com.xl.lc;

/**
 * @ClassName : lc50
 * @Author : Xulian
 * @Date : 2020/10/21 20:35
 */
public class lc50_KuaiSuMi {
    //快速幂，用二进制解决，巧妙的是，用x的平方保存乘积的每一项
    //res = x ^ [（2^0）*b1 ] * x ^ {(2^1)*b2 } * x ^［（２^2）*b3］·····
    //只要用x不断平方就可以了，bi如果对应的位置是1，那么就res *= x，很好的答案。
    public double myPow(double x, int n) {
        if (x == 0.0d) return x;
        long b = n;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        double res = 1.0;
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
