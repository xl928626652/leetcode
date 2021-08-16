package com.xl.msjd;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1717_Mark_Trie {
    public int[][] multiSearch(String big, String[] smalls) {
        int[][] res = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            if (smalls[i].equals("")) {
                res[i] = new int[0];
                break;
            }
            List<Integer> list = new ArrayList<>();
            String str = big;
            int len = 0;
            while (str.contains(smalls[i])) {
                list.add(len + str.indexOf(smalls[i]));
                len = len + str.indexOf(smalls[i]) + 1;
                if (len >= big.length()) break;
                str = str.substring(str.indexOf(smalls[i]) + 1);
            }
            res[i] = list.stream().mapToInt(Integer::valueOf).toArray();
        }
        return res;
    }

    public static void main(String[] args) {
        String big = "mississippi";
        String[] smalls = new String[]{"i"};
        new msjd1717_Mark_Trie().multiSearch(big, smalls);
    }
}
