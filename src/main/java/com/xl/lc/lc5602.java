package com.xl.lc;

import com.xl.base.HeapSort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc5602 {
    //    public boolean closeStrings(String word1, String word2) {
//        int n1 = word1.length(), n2 = word2.length();
//        if (n1 != n2) return false;
//        int[] ints1 = new int[26], ints2 = new int[26];
//        for (int i = 0; i < word1.length(); i++) {
//            char char1 = word1.charAt(i), char2 = word2.charAt(i);
//            ints1[char1 - 'a']++;
//            ints2[char2 - 'a']++;
//        }
//        for (int i = 0; i < 26; i++) {
//            if (ints1[i] == 0 && ints2[i] != 0) {
//                return false;
//            }
//            if (ints1[i] != 0 && ints2[i] == 0) {
//                return false;
//            }
//        }
//        Arrays.sort(ints1);
//        Arrays.sort(ints2);
//        int index = 0;
//        while (index < 26) {
//            if (ints1[index] != ints2[index]) {
//                return false;
//            }
//            index++;
//        }
//        return true;
//    }
    //大佬的解法
    public boolean closeStrings(String word1, String word2) {
        return Arrays.equals(count(word1), count(word2)) && state(word1) == state(word2);
    }

    public int state(String s) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans |= 1 << (c - 'a');
        }
        return ans;
    }

    public int[] count(String s) {
        int[] ans = new int['z' - 'a' + 1];
        for (char c : s.toCharArray()) {
            ans[c - 'a']++;
        }
        Arrays.sort(ans);
        return ans;
    }
}
