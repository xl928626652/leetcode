package com.xl.alibaba.SingleTon;

/**
 * @ClassName : HungrySingleTon
 * @Author : Xulian
 * @Date : 2021/3/20 15:15
 */
public class HungrySingleTon {
    private static HungrySingleTon hungrySingleTon = new HungrySingleTon();

    private HungrySingleTon() {
    }

    public static HungrySingleTon getHungrySingleTon() {
        return hungrySingleTon;
    }

}
