package com.xl.jzoffer;
//这一题挺有意思的
public class JZoffer_14_2_Mark {
    int p=(int)1e9+7;//1e9+7居然是double
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int b = n % 3, p = (int)1e9+7;
        long rem = 1, x = 3;
        for(int a = n / 3 - 1; a > 0; a /= 2) {
            if(a % 2 == 1) rem = (rem * x) % p;
            x = (x * x) % p;
        }
        if(b == 0) return (int)(rem * 3 % p);
        if(b == 1) return (int)(rem * 4 % p);
        return (int)(rem * 6 % p);
        
    }
}
