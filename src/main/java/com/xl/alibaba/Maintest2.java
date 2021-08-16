package com.xl.alibaba;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName : Maintest2
 * @Author : Xulian
 * @Date : 2021/3/10 16:22
 */
public class Maintest2 {

    public static void main(String[] args) {
        double d = 0.00005;
        System.out.println(String.format("%.2f", d));
        System.out.println(Integer.toBinaryString(1024));
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        Deque<Integer> stk = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(a));
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && a[stk.peekLast()] <= a[i]) {
                int x = stk.pollLast();
                right[x] = i;
            }
            left[i] = stk.isEmpty() ? -1 : stk.peekLast();
            stk.offerLast(i);
        }

        double res = 0;
        for (int i = 0; i < n; i++) {
            res += a[i] * (right[i] - i) * (i - left[i]);

        }
        res /= (n * (n + 1) / 2);
        res = (long) (res * Math.pow(10, 6)) / Math.pow(10, 6);
        System.out.println(String.format("%.6f", res));
    }

}
