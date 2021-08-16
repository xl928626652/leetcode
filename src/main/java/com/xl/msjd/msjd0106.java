package com.xl.msjd;

public class msjd0106 {
    public String compressString(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = S.length();
        int index = 0;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
            int count = 1;
            while (i < chars.length - 1 && chars[i + 1] == chars[i]) {
                count++;
                i++;
            }
            stringBuilder.append(count);
        }
        return stringBuilder.length() >= len ? S : stringBuilder.toString();
    }

}
