package com.xl.alibaba;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName : ObjectCopy
 * @Author : Xulian
 * @Date : 2021/3/25 22:00
 */
public class ObjectCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher("riemann", 28);
        Teacher otherTeacher = (Teacher) teacher.clone();
        System.out.println(teacher);
        System.out.println(otherTeacher);

        System.out.println("*************");
        String s1 = "abc";//初始化一个字符串变量s1
        String s2 = s1; //把s1表示的字符串复制给s2
        s1 = "cde";//改变s1的字符串内容
        System.out.println(s2);//输出s2，内容还是 "abc",不受原来字符串变量的改变而改变
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> cmap = new ConcurrentHashMap<>();
    }
}

class Teacher implements Cloneable {
    private String name;
    private int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        return object;
    }
}
