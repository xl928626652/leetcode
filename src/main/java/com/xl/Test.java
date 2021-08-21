package com.xl;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName : test
 * @Author : Xulian
 * @Date : 2020/10/16 11:26
 */

public class Test {
    int a;
    int ccc = 1;
    //    public void f(int i ,String p){
//
//    }
//    public void f(String p, int i){
//
//    }
    char c;

    Test() {
        this(5);
    }

    Test(int b) {
        a = b + 1;
    }

    public static void f(Test d) {
        Test t = new Test();
        int res = d.f(d.a);
        System.out.println(res);
//        System.out.println(a);        Error
    }

    public int f(int a) {
        return a;
    }

    public static void main(String[] args) throws Throwable {
//        int goalTotal = 2*85 + 90 + 3*75+ 2*95+3*90+2*85+2*90+3*80+2*90+2*85+2*80+2*85+2*75+85+2*90;
//        int goalTotal = 2 * 85 + 90 + 3 * 75 + 2 * 95 + 3 * 90 + 2 * 85 + 2 * 90 + 3 * 80 + 2 * 90 + 2 * 85 + 2 * 80 + 2 * 85 + 2 * 75 + 85 + 2 * 90;
//        int creditTotal = 31;
//        double res = (double) goalTotal / creditTotal;
//        System.out.println(res);
//        System.out.println(res * 0.25);
        //84.83870967741936
        //21.20967741935484

        /*int goalTotal = 2 * 85 + 90 + 3 * 77 + 2 * 95 + 3 * 91 + 2 * 87 + 2 * 91 + 3 * 83 + 2 * 91 + 2 * 87 + 2 * 82 + 2 * 89 + 2 * 76 + 89 + 2 * 94;
        int creditTotal = 31;
        double res = (double) goalTotal / creditTotal;
        System.out.println(res);
        System.out.println(res * 0.25);
        //86.96
        //21.74*/

//        int b = 1;
//        int a = 1;
//        label:
//        while(a > 0){
//            a--;
//            if (a == 0) continue label;
//            b++;
//        }

        Test asad = new Test();
        asad.f(asad);
        Test.f(asad);
        System.out.println(":" + (int) asad.c + ":");
        String[] strings = new String[5];
        System.out.println(strings.length);
        Integer[] integer = new Integer[5];
//        System.out.println(integer[0].intValue()); // Exception in thread "main" java.lang.NullPointerException
        System.out.println(Arrays.toString(new String[]{"123", "12312"}));
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(1);
    }
}
