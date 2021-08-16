package com.xl.msjd;

import java.util.Arrays;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1615 {
    public int[] masterMind(String solution, String guess) {
        char[] charsSolution = solution.toCharArray();
        char[] charsGuess = guess.toCharArray();
        int[] res = new int[2];
        int[] colorSolution = new int[4];
        int[] colorGuess = new int[4];
        for (int i = 0; i < charsSolution.length; i++) {
            if (charsSolution[i] == charsGuess[i]) {
                res[0]++;
            } else {
                if (charsSolution[i] == 'R') colorSolution[0]++;
                if (charsSolution[i] == 'G') colorSolution[1]++;
                if (charsSolution[i] == 'B') colorSolution[2]++;
                if (charsSolution[i] == 'Y') colorSolution[3]++;
                if (charsGuess[i] == 'R') colorGuess[0]++;
                if (charsGuess[i] == 'G') colorGuess[1]++;
                if (charsGuess[i] == 'B') colorGuess[2]++;
                if (charsGuess[i] == 'Y') colorGuess[3]++;
            }
        }
        for (int i = 0; i < charsGuess.length; i++) {
            res[1] += Math.min(colorSolution[i], colorGuess[i]);
        }
        return res;
    }
}
