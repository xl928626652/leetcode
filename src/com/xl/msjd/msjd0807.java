package com.xl.msjd;

import java.util.LinkedList;
import java.util.List;

public class msjd0807 {
    List<String> list;

    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        list = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            recur(i, chars, stringBuilder);
        }
        return list.toArray(new String[]{});
    }

    public void recur(int index, char[] chars, StringBuilder stringBuilder) {
        if (stringBuilder.indexOf(String.valueOf(chars[index])) != -1) {
            return;
        }
        stringBuilder.append(chars[index]);
        if (stringBuilder.length() == chars.length) {
            list.add(stringBuilder.toString());
        }
        for (int i = 0; i < chars.length; i++) {
            recur(i, chars, stringBuilder);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

    }
}
