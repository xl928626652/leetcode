package com.xl.lc;

import java.util.HashSet;

/**
 * @ClassName : lc149
 * @Author : Xulian
 * @Date : 2020/10/18 13:57
 */
public class lc149_Mark_Hard {
    //    作者：windliang
//    链接：https://leetcode-cn.com/problems/max-points-on-a-line/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--35/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int i = 0;
        //判断所有点是否都相同的特殊情况
        for (; i < points.length - 1; i++) {
            if (points[i][0] != points[i + 1][0] || points[i][1] != points[i + 1][1]) {
                break;
            }

        }
        if (i == points.length - 1) {
            return points.length;
        }
        HashSet<String> set = new HashSet<>();
        int max = 0;
        for (i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    continue;
                }
                String key = getK(points[i][0], points[i][1], points[j][0], points[j][1])
                        + "@"
                        + getB(points[i][0], points[i][1], points[j][0], points[j][1]);
                if (set.contains(key)) {
                    continue;
                }
                int tempMax = 0;
                for (int k = 0; k < points.length; k++) {
                    if (k != i && k != j) {
                        if (test(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1])) {
                            tempMax++;
                        }
                    }

                }
                if (tempMax > max) {
                    max = tempMax;
                }
                set.add(key);
            }
        }
        return max + 2;
    }

    private double getB(int x1, int y1, int x2, int y2) {
        if (y2 == y1) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) (x2 - x1) * (-y1) / (y2 - y1) + x1;
    }

    private double getK(int x1, int y1, int x2, int y2) {
        if (x2 - x1 == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) (y2 - y1) / (x2 - x1);
    }

    private boolean test(int x1, int y1, int x2, int y2, int x, int y) {
        return (long) (y2 - y1) * (x - x2) == (long) (y - y2) * (x2 - x1);
    }


}
