package com.xl.msjd;

import java.util.Arrays;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1603 {
    /*double[] ans = new double[0];

    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = start1[0], y1 = start1[1];
        int x2 = end1[0], y2 = end1[1];
        int x3 = start2[0], y3 = start2[1];
        int x4 = end2[0], y4 = end2[1];

        // 判断 (x1, y1)~(x2, y2) 和 (x3, y3)~(x4, y4) 是否平行
        if ((y4 - y3) * (x2 - x1) == (y2 - y1) * (x4 - x3)) {
            // 若平行，则判断 (x3, y3) 是否在「直线」(x1, y1)~(x2, y2) 上
            if ((y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)) {
                // 判断 (x3, y3) 是否在「线段」(x1, y1)~(x2, y2) 上
                if (inside(x1, y1, x2, y2, x3, y3)) {
                    update(x3, y3);
                }
                // 判断 (x4, y4) 是否在「线段」(x1, y1)~(x2, y2) 上
                if (inside(x1, y1, x2, y2, x4, y4)) {
                    update(x4, y4);
                }
                // 判断 (x1, y1) 是否在「线段」(x3, y3)~(x4, y4) 上
                if (inside(x3, y3, x4, y4, x1, y1)) {
                    update(x1, y1);
                }
                // 判断 (x2, y2) 是否在「线段」(x3, y3)~(x4, y4) 上
                if (inside(x3, y3, x4, y4, x2, y2)) {
                    update(x2, y2);
                }
            }
            // 在平行时，其余的所有情况都不会有交点
        } else {
            // 联立方程得到 t1 和 t2 的值
            double t1 = (double) (x3 * (y4 - y3) + y1 * (x4 - x3) - y3 * (x4 - x3) - x1 * (y4 - y3)) / ((x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1));
            double t2 = (double) (x1 * (y2 - y1) + y3 * (x2 - x1) - y1 * (x2 - x1) - x3 * (y2 - y1)) / ((x4 - x3) * (y2 - y1) - (x2 - x1) * (y4 - y3));
            // 判断 t1 和 t2 是否均在 [0, 1] 之间
            if (t1 >= 0.0 && t1 <= 1.0 && t2 >= 0.0 && t2 <= 1.0) {
                ans = new double[]{x1 + t1 * (x2 - x1), y1 + t1 * (y2 - y1)};
            }
        }
        return ans;
    }

    // 判断 (xk, yk) 是否在「线段」(x1, y1)~(x2, y2) 上
    // 这里的前提是 (xk, yk) 一定在「直线」(x1, y1)~(x2, y2) 上
    public boolean inside(int x1, int y1, int x2, int y2, int xk, int yk) {
        // 若与 x 轴平行，只需要判断 x 的部分
        // 若与 y 轴平行，只需要判断 y 的部分
        // 若为普通线段，则都要判断
        return (x1 == x2 || (Math.min(x1, x2) <= xk && xk <= Math.max(x1, x2))) && (y1 == y2 || (Math.min(y1, y2) <= yk && yk <= Math.max(y1, y2)));
    }

    public void update(double xk, double yk) {
        // 将一个交点与当前 ans 中的结果进行比较
        // 若更优则替换
        if (ans.length == 0 || xk < ans[0] || (xk == ans[0] && yk < ans[1])) {
            ans = new double[]{xk, yk};
        }
    }
*/
    class PointAndIndex{
        int point;
        int index;
        PointAndIndex(int point,int index){
            this.point = point;
            this.index = index;
        }
    }

    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double[] res = new double[2];
        double intercept_x_1 = end1[0] - start1[0];
        double intercept_y_1 = end1[1] - start1[1];
        double intercept_x_2 = end2[0] - start2[0];
        double intercept_y_2 = end2[1] - start2[1];
        if (intercept_x_1 == 0 && intercept_x_2 == 0) {
            if (end1[0] != end2[0]) {
                return new double[]{};
            } else {
                //start1[1], end1[1], start2[1], end2[1]
                PointAndIndex Start1 = new PointAndIndex(start1[1],0);
                PointAndIndex End1 = new PointAndIndex(end1[1],0);
                PointAndIndex Start2 = new PointAndIndex(start2[1],1);
                PointAndIndex End2 = new PointAndIndex(end2[1],1);
                PointAndIndex[] pointAndIndices = new PointAndIndex[]{Start1,End1,Start2,End2};
                Arrays.sort(pointAndIndices,(o1, o2) -> {
                    return o1.point-o2.point;
                });
                if(pointAndIndices[0].index==pointAndIndices[3].index){
                    return new double[]{end1[0],pointAndIndices[1].point};
                }else{
                    if(pointAndIndices[0].index==pointAndIndices[1].index){
                        return new double[2];
                    }else {
                        return new double[]{end1[0],pointAndIndices[1].point};
                    }
                }
            }
        }else if (intercept_x_1 == 0 || intercept_x_2 == 0){
            if(intercept_x_1 == 0){
                if(start1[0]>start2[0] && start1[0] > end2[0] || start1[0]<start2[0] && start1[0] < end2[0]){
                    return new double[]{};
                }else{
                    double k = intercept_y_2/intercept_x_2;
                    double y = k * (start2[0]-start1[0]) + start1[1];
                    if(y>=Math.min(start1[1],end1[1]) && y<= Math.max(start1[1],end1[1])){
                        return new double[]{start1[0],y};
                    }else{
                        return new double[]{};
                    }
                }
            }else{
                if(start2[0]>start1[0] && start2[0] > end1[0] || start2[0]<start1[0] && start2[0] < end1[0]){
                    return new double[]{};
                }else{
                    double k = intercept_y_1/intercept_x_1;
                    double y = k * (start1[0]-start2[0]) + start2[1];
                    if(y>=Math.min(start2[1],end2[1]) && y<= Math.max(start2[1],end2[1])){
                        return new double[]{start2[0],y};
                    }else{
                        return new double[]{};
                    }
                }
            }
        }else {
            double k1 = intercept_y_1/intercept_x_1;
            double k2 = intercept_y_2/intercept_x_2;
            if(k1 == k2){

            }
        }
        return res;
    }
}
