package com.xl.msjd;

import java.util.Arrays;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1604 {
    //C++版的这个好啊，对每一个都遍历一下，然后对i和j判断，从而得到对角线的。
    //而且他这个是加法，加到N，才行，这个挺妙的。
    //class Solution {
    //public:
    //    string tictactoe(vector<string>& board) {
    //        int N = board.size();
    //        vector<int> row(N);
    //        vector<int> col(N);
    //        int dia1 = 0, dia2 = 0; // 主副对角线
    //        bool pending = 0;
    //        for (int i = 0; i < N; ++i) {
    //            for (int j = 0; j < N; ++j) {
    //                int offset = 0;
    //                if (board[i][j] == 'O') offset = 1;
    //                else if (board[i][j] == 'X') offset = -1;
    //                else pending = 1; // 有空位
    //                row[i] += offset;
    //                col[j] += offset;
    //                if (i == j) dia1 += offset;
    //                if (i + j == N - 1) dia2 += offset;
    //            }
    //        }
    //        if (dia1 == N || dia2 == N) return "O";
    //        if (dia1 == -N || dia2 == -N) return "X";
    //        for (int k = 0; k < N; ++k) {
    //            if (row[k] == N || col[k] == N ) return "O";
    //            else if (row[k] == -N || col[k] == -N) return "X";
    //        }
    //        if (!pending) return "Draw";
    //        else return "Pending";
    //    }
    //};
    public String tictactoe(String[] board) {
        int pending = 0;
        int diagonalX = 0, diagonalO = 0;
        int theOtherDiagonalX = 0, theOtherDiagonalO = 0;
        char[][] c = new char[board.length][board.length];
        for (int i = 0; i < c.length; i++) {
            c[i]=board[i].toCharArray();
        }
        for (int i = 0; i < board.length; i++) {
            char[] chars = c[i];
            if (chars[i] == 'X') {
                diagonalX++;
            } else if (chars[i] == 'O') {
                diagonalO++;
            } else {
                pending++;
            }
            if (chars[board.length - i - 1] == 'X') {
                theOtherDiagonalX++;
            } else if (chars[board.length - i - 1] == 'O') {
                theOtherDiagonalO++;
            } else {
                pending++;
            }
            int rowX = 0, rowO = 0;
            int colX = 0, colO = 0;
            for (int j = 0; j < board.length; j++) {
                if (chars[j] == 'X') {
                    rowX++;
                } else if (chars[j] == 'O') {
                    rowO++;
                } else {
                    pending++;
                }
                if(c[j][i]=='X'){
                    colX++;
                }else if (c[j][i]=='O'){
                    colO++;
                }else {
                    pending++;
                }
            }
            if (rowX == chars.length || rowO == chars.length) {
                return rowX == chars.length ? "X" : "O";
            }
            if (colX == chars.length || colO == chars.length) {
                return colX == chars.length ? "X" : "O";
            }
        }

        if (diagonalX == board.length || diagonalO == board.length) {
            return diagonalX == board.length ? "X" : "O";
        }
        if (theOtherDiagonalX == board.length || theOtherDiagonalO == board.length) {
            return theOtherDiagonalX == board.length ? "X" : "O";
        }
        return pending == 0 ? "Draw" : "Pending";
    }
}
