package com.xl.lc;

/**
 * @ClassName : lc1540
 * @Author : Xulian
 * @Date : 2020/10/31 17:20
 */
public class lc1540 {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()){
            return false;
        }
        int[] ints = new int[26];
        int max = 0;
        for (int i = 0; i < s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            int j = tc - sc;
            if (j == 0) {
            }
            else if (j < 0){
                j = j + 26;
                max = Math.max(max, ints[j] * 26 + j);
                ints[j]++;
            }else {
                max = Math.max(max, ints[j]* 26  + j);
                ints[j]++;
            }

        }
        return max <= k;
    }
}
