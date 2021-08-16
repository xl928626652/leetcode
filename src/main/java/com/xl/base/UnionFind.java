package com.xl.base;

import java.util.Arrays;

public class UnionFind {
    // 连通分量个数
    private int count;
    // 存储一棵树
    private int[] parent;
    // 记录树的“重量”
    private int[] size;

    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }


    //注意笔试的时候，可能给的参数中的数字是从1~N。
    //需要把这些参数全部-1，才可以
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;

        // 小树接到大树下面，较平衡
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }

    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }


    public int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public int count() {
        return count;
    }

    public int maxSize() {
        int max = size[0];
        for (int i = 0; i < size.length; i++) {
            if (size[i] > max)
                max = size[i];
        }
        return max;
    }

    public int find(int[] parent, int x) {
        return parent[x] == x ? x : (parent[x] = find(parent, parent[x]));
    }

    public static void main(String[] args) {
        int[] parent = new int[]{0, 3, 2, 5, 4, 7, 6, 9, 8, 9};
        int res = new UnionFind(1).find(parent, 1);
        System.out.println(res + " -- " + Arrays.toString(parent));

    }
}
