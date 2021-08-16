package com.xl.alibaba;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName : CGLIB
 * @Author : Xulian
 * @Date : 2021/3/25 14:35
 */
public class CGLIB {
    static class MyIntercept implements MethodInterceptor {
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("before method run...");
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("After");
            return result;
        }
    }

    public void test() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CGLIB.class);
        MyIntercept myIntercept = new MyIntercept();
        enhancer.setCallback(myIntercept);
        CGLIB cglib = (CGLIB) enhancer.create();
        cglib.test();
    }
}
