package com.xl.jzoffer;

import java.util.Arrays;

public class JZoffer_12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.println(Arrays.toString(board[0]));
                System.out.println(Arrays.toString(board[1]));
                System.out.println(Arrays.toString(board[2]));
                boolean res=dfs(board, words, i, j, 0);
                System.out.println(Arrays.toString(board[0]));
                System.out.println(Arrays.toString(board[1]));
                System.out.println(Arrays.toString(board[2]));
                if(res=true) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
//        board[i][j] = tmp;
        return res;
    }
    public static void main(String[] args) {
        //01test
      /*  Main main = new Main();
        Main main_new = new Main();
        System.out.println(main.getA());
        main.setA(5);
        System.out.println(main.getA());
        main.test();
        System.out.println(main.getA());*/

        //02test
        JZoffer_12 jZoffer_12 = new JZoffer_12();
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        boolean res =jZoffer_12.exist(board,word);
    }
}
