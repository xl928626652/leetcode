package com.xl.alibaba;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName : JDKProxy
 * @Author : Xulian
 * @Date : 2021/3/26 21:29
 */
interface IDayWork {
    void breakfast();

    void lunch();

    void dinner();
}

class DayWorkImpl implements IDayWork {
    @Override
    public void breakfast() {
        System.out.println("吃早饭");
    }

    @Override
    public void lunch() {
        System.out.println("吃午饭");
    }

    @Override
    public void dinner() {
        System.out.println("吃晚饭");
    }
}

class JDKProxy implements InvocationHandler {
    private Object target;

    public JDKProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("吃饭之前要洗手");
        //调用真正的方法
        Object retVal = method.invoke(target, args);
        System.out.println("吃饭之后要洗碗");
        return retVal;
    }
}

public class JDKProxyDemo {
    public static void main(String[] args) {
        DayWorkImpl dayWork = new DayWorkImpl();
        JDKProxy timeHandler = new JDKProxy(dayWork);
        IDayWork work = (IDayWork) Proxy.newProxyInstance(dayWork.getClass().getClassLoader(), dayWork.getClass().getInterfaces(), timeHandler);
        work.breakfast();
        work.lunch();
        work.dinner();
        System.out.println(work.getClass());

    }
}

