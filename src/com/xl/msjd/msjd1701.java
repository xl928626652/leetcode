package com.xl.msjd;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1701 {
    //递归
//    public int add(int a, int b) {
//        if (a == 0) return b;
//        if (b == 0) return a;
//        return add(a ^ b, (a & b) << 1);
//    }

    //
    public int add(int a, int b) {
        int jinwei = (a & b) << 1;
        int feijinwei = a ^ b;
        //进位是Carry，noCarry是非进位
        while (jinwei !=0 && feijinwei!=0){
            jinwei = (jinwei & feijinwei) <<1;
            feijinwei = jinwei ^ feijinwei;
        }
        return jinwei==0 ? feijinwei:jinwei;
    }

}
