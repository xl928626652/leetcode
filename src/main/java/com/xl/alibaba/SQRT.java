package com.xl.alibaba;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.LinkedList;

/**
 * @ClassName : SQRT
 * @Author : Xulian
 * @Date : 2021/3/19 21:21
 */
public class SQRT {

    public static double Sqrt(double c) {
        if (c < 0) return Double.NaN; //既然要开平方，肯定不能为负啊
        double err = 1e-2; //精度
        double x = c; //迭代的初始值
        while (Math.abs(x - c / x) > err) { //没达到精度，那么继续迭代
            x = (x + c / x) / 2.0;
        }
        return x;
    }


    public static void main(String[] args) {
        int b = (int) 10102;
        int c = (int) Math.sqrt(b);
//        System.out.println(Math.sqrt(5.5));
//        System.out.println(Math.sqrt(b));
//        System.out.println(mySqrt(b));
        System.out.println(Sqrt(b));
        System.out.println(Math.sqrt(b));
//        System.out.println(Sqrt(b));
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
    }
}
