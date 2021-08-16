package com.xl.lc;

import com.xl.base.MGraph;

public class lc1584 {
    public int minCostConnectPoints(int[][] points) {
        MGraph mGraphPrim = new MGraph(points.length, (points.length * (points.length - 1)) / 2);

        //initGraph部分
        for (int i = 0; i < mGraphPrim.v_num; i++) {
            mGraphPrim.vertices[i] = i;
        }
        for (int i = 0; i < mGraphPrim.v_num; i++) {
            for (int j = 0; j < mGraphPrim.v_num; j++) {
                if (i == j) {
                    mGraphPrim.adjMatrix[i][j] = 0;
                } else {
                    mGraphPrim.adjMatrix[i][j] = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                }
            }
        }
        return mGraphPrim.Prim(0);

    }
}
