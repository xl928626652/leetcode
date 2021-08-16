package com.xl.msjd;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1613 {
    public double[] cutSquares(int[] square1, int[] square2) {
        double heart1_x = square1[0] + (double) square1[2] / 2;
        double heart1_y = square1[1] + (double) square1[2] / 2;
        double heart2_x = square2[0] + (double) square2[2] / 2;
        double heart2_y = square2[1] + (double) square2[2] / 2;
        if (heart1_x == heart2_x && heart1_y == heart2_y) {
            int width = Math.max(square1[2], square2[2]);
            return new double[]{heart1_x, heart1_y - (double) (width) / 2, heart1_x, heart1_y + (double) (width) / 2};
        } else if (heart1_x == heart2_x) {
            return new double[]{heart1_x, Math.min(heart1_y - (double) square1[2] / 2, heart2_y - (double) square2[2] / 2), heart1_x, Math.max(heart1_y + (double) square1[2] / 2, heart2_y + (double) square2[2] / 2)};
        } else if (heart1_y == heart2_y) {
            return new double[]{Math.min(heart1_x - (double) square1[2] / 2, heart2_x - (double) square2[2] / 2), heart1_y, Math.max(heart1_x + (double) square1[2] / 2, heart2_x + (double) square2[2] / 2), heart2_y};
        } else {
            double k = (heart1_y - heart2_y) / (heart1_x - heart2_x);
            double x1, y1, x2, y2, x3, y3, x4, y4;
            if (Math.abs(k) >= 1) {
                x1 = heart1_x + (double) square1[2] / 2 / Math.abs(k);
                x2 = heart1_x - (double) square1[2] / 2 / Math.abs(k);
                x3 = heart2_x + (double) square2[2] / 2 / Math.abs(k);
                x4 = heart2_x - (double) square2[2] / 2 / Math.abs(k);
                double x_min = Math.min(x2, x4);
                double x_max = Math.max(x1, x3);
                return new double[]{x_min, heart1_y + k * (x_min - heart1_x), x_max, heart1_y + k * (x_max - heart1_x)};
            } else {
                double x_min = Math.min(square1[0], square2[0]);
                double x_max = Math.max(square1[0] + (double) square1[2], square2[0] + (double) square2[2]);
                return new double[]{x_min, heart1_y + k * (x_min - heart1_x), x_max, heart1_y + k * (x_max - heart1_x)};
            }
        }
    }
}
