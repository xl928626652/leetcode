package com.xl.msjd;

public class msjd0109 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0) return true;
        char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
        boolean flag = false;
        for (int j = 0; j < chars2.length; j++) {
            if (chars2[j] == chars1[0] && !flag) {
                flag = isSub(chars1, chars2, j);
            }
        }
        return flag;
    }

    public boolean isSub(char[] chars1, char[] chars2, int j) {
        for (int i = 0; i < chars1.length; i++, j = (j + 1) % chars2.length) {
            if (chars1[i] != chars2[j]) {
                return false;
            }
        }
        return true;
    }
}
