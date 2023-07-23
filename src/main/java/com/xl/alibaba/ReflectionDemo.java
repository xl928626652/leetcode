package com.xl.alibaba;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName : ReflectionDemo
 * @Author : Xulian
 * @Date : 2021/3/30 23:20
 */
public class ReflectionDemo {
    static int d = 0;

    public int methodA(int c, int b) {
        return (int) 1e9;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Method method = Class.forName("com.xl.alibaba.ReflectionDemo").getMethod("methodA", int.class, int.class);
        ReflectionDemo reflectionDemo = (ReflectionDemo) Class.forName("com.xl.alibaba.ReflectionDemo").newInstance();
        Field field = reflectionDemo.getClass().getField("d");
        System.out.println(field);
        System.out.println(method.invoke(reflectionDemo, 1, 1));
    }
}
