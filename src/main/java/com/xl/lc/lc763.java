package com.xl.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : lc763
 * @Author : Xulian
 * @Date : 2020/10/22 10:13
 */
public class lc763 {
    List<Integer> list;

    public List<Integer> partitionLabels(String S) {
        list = new ArrayList<>();
        recur(0, S);
        return list;
    }

    public void recur(int begin, String S) {
        if (begin >= S.length()) {
            return;
        }
        char first = S.charAt(begin);
        int range = S.lastIndexOf(first);
        for (int i = begin; i < range; i++) {
            range = Math.max(range, S.lastIndexOf(S.charAt(i)));
        }

        list.add(range - begin + 1);
        recur(range + 1, S);
    }
}
