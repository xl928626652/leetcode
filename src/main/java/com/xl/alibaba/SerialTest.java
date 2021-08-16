package com.xl.alibaba;

import java.io.Serializable;

/**
 * @ClassName : SerialTest
 * @Author : Xulian
 * @Date : 2021/4/8 16:01
 */
public class SerialTest implements Serializable {
    private transient int a;

    SerialTest(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
