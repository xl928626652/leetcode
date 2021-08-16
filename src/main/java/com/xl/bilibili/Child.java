package com.xl.bilibili;

import com.xl.alibaba.Father;

/**
 * @ClassName : Child
 * @Author : Xulian
 * @Date : 2021/4/9 16:55
 */
public class Child extends Father {
    public int b = 2;

    public void test() {
        Child f = new Child();
        //方法中也可以
    }

    public static void main(String[] args) {
        Child f = new Child();
        f.b = 2;
        //f.a如果这是protected修饰，可以访问 包访问修饰，不可访问
    }
}
