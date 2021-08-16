package com.xl.msjd;

import java.util.LinkedList;
import java.util.List;

public class msjd0808 {
    List<String> list;
    boolean[] visited;

    public String[] permutation(String S) {
        char[] chars = S.toCharArray();
        list = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] visited=new boolean[chars.length];
        for (int i = 0; i < chars.length; i++) {
            recur(i, chars, stringBuilder, visited);
        }
        return list.toArray(new String[]{});
    }

    public void recur(int index, char[] chars, StringBuilder stringBuilder, boolean[] visited) {
        if (stringBuilder.length() > chars.length || visited[index]) {
            return;
        }
        stringBuilder.append(chars[index]);
        visited[index] = true;
        if (stringBuilder.length() == chars.length && !list.contains(stringBuilder.toString())) {
            list.add(stringBuilder.toString());
        }
        for (int i = 0; i < chars.length; i++) {
            recur(i, chars, stringBuilder, visited);
        }
        visited[index] = false;
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

    }
}
