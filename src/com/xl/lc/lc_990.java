package com.xl.lc;

import com.xl.base.UnionFind;

public class lc_990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        boolean flag = true;
        for (String s : equations) {
            char l = s.charAt(0);
            char r = s.charAt(3);
            if (s.charAt(1) == '=') {
                unionFind.union(l - 'a', r - 'a');
            }
        }
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                flag = unionFind.connected(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }
        return flag;
    }
}
