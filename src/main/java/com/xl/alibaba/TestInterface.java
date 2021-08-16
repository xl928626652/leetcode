package com.xl.alibaba;

public interface TestInterface {
    int a = 1;
    int c = 1;

    default void get() {
        int b = 1;
    }

    default void put() {
        int b = 1;
    }

    int set();
}
