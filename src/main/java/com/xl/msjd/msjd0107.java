package com.xl.msjd;

public class msjd0107 {
    public void rotate(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (top < bottom && left < right) {
            for (int i = 0; i < bottom - top; i++) {

                for (int j = right; j > left; j--) {
                    int tmp = matrix[top][j];
                    matrix[top][j] = matrix[top][j - 1];
                    matrix[top][j - 1] = tmp;
                }
                for (int j = top; j < bottom; j++) {
                    int tmp = matrix[j][left];
                    matrix[j][left] = matrix[j + 1][left];
                    matrix[j + 1][left] = tmp;
                }
                for (int j = left; j < right; j++) {
                    int tmp = matrix[bottom][j];
                    matrix[bottom][j] = matrix[bottom][j + 1];
                    matrix[bottom][j + 1] = tmp;
                }
                for (int j = bottom; j > top + 1; j--) {
                    int tmp = matrix[j][right];
                    matrix[j][right] = matrix[j - 1][right];
                    matrix[j - 1][right] = tmp;
                }
            }
            top++;
            bottom--;
            left++;
            right--;
        }

    }
}
