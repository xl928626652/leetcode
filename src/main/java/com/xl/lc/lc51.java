package com.xl.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName : lc51
 * @Author : Xulian
 * @Date : 2020/12/24 22:50
 */
public class lc51 {
    public List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        List<List<String>> list = new ArrayList<>();
        bitBF(list, queens, n, 0, 0, 0, 0);
        return list;
    }

    public void bitBF(List<List<String>> list, int[] queens, int n, int row, int columns, int diag1, int diag2) {
        if (row == n) {
            List<String> l_total = generate(queens);
            list.add(l_total);
        } else {
            int available_pos = (((1 << n) - 1) & (~(columns | diag1 | diag2)));
            while (available_pos != 0) {
                int col = available_pos & (-available_pos);
                available_pos = available_pos & (available_pos - 1);
                int index = Integer.bitCount(col - 1);
                queens[row] = index;
                bitBF(list, queens, n, row + 1, columns | col, (diag1 | col) << 1, (diag2 | col) >> 1);
                queens[row] = -1;
            }
        }
    }

    public List<String> generate(int[] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            char[] chars = new char[queens.length];
            Arrays.fill(chars, '.');
            chars[queens[i]] = 'Q';
            list.add(String.valueOf(chars));
        }
        return list;

    }

    public static void main(String[] args) {
        int n = 15;//15皇后
        List<List<String>> list = new lc51().solveNQueens(n);
        for (List<String> listi : list) {
            for (String s : listi) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
