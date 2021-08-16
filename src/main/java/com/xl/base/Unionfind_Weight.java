package com.xl.base;

/**
 * @ClassName : Unionfind_Weightr
 * @Author : Xulian
 * @Date : 2021/1/6 17:18
 */
public class Unionfind_Weight {
    public static void main(String[] args) {
        int[] parent = new int[10];
        // x / y = val

    }

    public static void merge(int[] f, double[] w, int x, int y, double val) {
        int fx = findf(f, w, x);
        int fy = findf(f, w, y);
        f[fx] = fy;
        w[fx] = val * w[y] / w[x];
    }

    public static int findf(int[] f, double[] w, int x) {
        if (f[x] != x) {
            int father = findf(f, w, f[x]);
            w[x] = w[x] * w[f[x]];
            f[x] = father;
        }
        return f[x];
    }
}
