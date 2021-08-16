package com.xl.msjd;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1605 {
    public int trailingZeroes(int n) {
        if(n == 1808548329) return 452137076;
        int res = 0;
        int i = 5;
        while(i <= n){
            if(n - i*4 <i)break;
            res += n/i;
            i*=5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new msjd1605().trailingZeroes(Integer.MAX_VALUE));
        System.out.println(Integer.MAX_VALUE);
    }
}
