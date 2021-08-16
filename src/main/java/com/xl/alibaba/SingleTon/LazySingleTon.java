package com.xl.alibaba.SingleTon;

/**
 * @ClassName : LazySingleTon
 * @Author : Xulian
 * @Date : 2021/3/20 15:15
 */
public class LazySingleTon {
    private static LazySingleTon lazySingleTon;

    private LazySingleTon() {
    }

    public static synchronized LazySingleTon getInstance() {
        if (lazySingleTon == null) {
            lazySingleTon = new LazySingleTon();
        }
        return lazySingleTon;
    }
}
