package com.xl.alibaba;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @ClassName : StringDemo
 * @Author : Xulian
 * @Date : 2021/3/30 21:39
 */


public class StringDemo extends StringTest {

    public static String appendStr(String s) {
        s += "bbb";
        return s;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        StringTest stringTest = new StringDemo();
        Field[] fields = Class.forName("com.xl.alibaba.Main").getFields();
        System.out.println(Arrays.toString(fields));
        System.out.println("********************");
        String s = new String("aaa");
        String ns = appendStr(s);
        System.out.println(ns);
        System.out.println(s);
//        String a = new String("asdf");
//        a += "bbb";
//        System.out.println(a);
//        StringBuilder sb = new StringBuilder();
//        System.out.println(res);
    }

}
