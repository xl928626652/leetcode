package com.xl.lc;

/**
 * @ClassName : lc5557
 * @Author : Xulian
 * @Date : 2020/11/28 22:31
 */
public class lc5557 {
    public int maxRepeating(String sequence, String word) {
        int res = 0;
        StringBuilder stringBuilder = new StringBuilder(word);
        for (int i = 1; i <= sequence.length() / word.length(); i++) {
            if (sequence.contains(stringBuilder.toString())) {
                res = i;
            }
            stringBuilder.append(word);
        }
        return res;
    }
}
