package com.xl.alibaba.SingleTon;

/**
 * @ClassName : DoubleCheckedLocking
 * @Author : Xulian
 * @Date : 2021/3/20 15:23
 */
public class DoubleCheckedLocking {
    private volatile static DoubleCheckedLocking doubleCheckedLocking;

    private DoubleCheckedLocking() {
    }

    public static DoubleCheckedLocking getInstance() {
        if (doubleCheckedLocking == null) {
            synchronized (DoubleCheckedLocking.class) {
                if (doubleCheckedLocking == null) {
                    doubleCheckedLocking = new DoubleCheckedLocking();
                }
            }
        }
        return doubleCheckedLocking;
    }

    public class A {
        int a;

        public int A() {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(DoubleCheckedLocking.class);

    }
}
