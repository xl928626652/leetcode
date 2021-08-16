package com.xl.jzoffer;

public class JZoffer_29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int Width = matrix.length, Length = matrix[0].length;
        int l = 0, r = Length - 1, t = 0, b = Width - 1, x = 0;
        int[] res = new int[Width * Length];
        while(true){
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if (++l > r) break;
        }
        return res;
    }
}
