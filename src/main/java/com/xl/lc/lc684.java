package com.xl.lc;

import com.xl.base.UnionFind;

public class lc684 {

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length);
        for (int[] ints : edges) {
            if (unionFind.connected(ints[0] - 1, ints[1] - 1)) {
                return ints;
            } else {
                unionFind.union(ints[0] - 1, ints[1] - 1);
            }
        }

        return new int[2];
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        new lc684().findRedundantConnection(edges);
    }
}
