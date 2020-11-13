package com.xl.msjd;

import java.util.Arrays;

public class msjd0108 {
    //用首行和首列保存矩阵中0的信息，很节省空间，也很节省时间
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowHaveZero = false;
        boolean isFirstColHaveZero = false;
        for(int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isFirstColHaveZero = true;
            }
        }

        for(int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                isFirstRowHaveZero = true;
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            if (isFirstColHaveZero) {
                matrix[i][0] = 0;
            }
        }

        for(int j = 0; j < matrix[0].length; j++) {
            if (isFirstRowHaveZero) {
                matrix[0][j] = 0;
            }
        }

    }
}
