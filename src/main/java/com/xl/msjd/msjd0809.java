package com.xl.msjd;

import java.util.LinkedList;
import java.util.List;

public class msjd0809 {
    List<String> list;

    public List<String> generateParenthesis(int n) {
        list = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        recur(0, stringBuilder, n, 0, 0);
        return list;
    }

    public void recur(int num, StringBuilder stringBuilder, int len, int numA, int numB) {
        if (numA < numB || numA > len) return;
        if (num == len * 2) {
            list.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                stringBuilder.append("(");
                recur(num + 1, stringBuilder, len, numA + 1, numB);
            } else {
                stringBuilder.append(")");
                recur(num + 1, stringBuilder, len, numA, numB + 1);
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
    }
}
