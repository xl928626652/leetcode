package com.xl.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : lc753
 * @Author : Xulian
 * @Date : 2021/2/25 13:16
 */
public class lc753 {
    Set<Integer> seen = new HashSet<Integer>();
    StringBuilder ans = new StringBuilder();
    int highest;
    int k;

    public String crackSafe(int n, int k) {
        highest = (int) Math.pow(10, n - 1);
        System.out.println(highest);
        this.k = k;
        dfs(0);
        for (int i = 1; i < n; i++) {
            ans.append('0');
        }
        return ans.toString();
    }

    public void dfs(int node) {
        for (int x = 0; x < k; ++x) {
            int nei = node * 10 + x;
            System.out.println(nei);
            if (!seen.contains(nei)) {
                seen.add(nei);
                dfs(nei % highest);
                ans.append(x);
            }
        }
    }

    public static void main(String[] args) {
        int n = 2, k = 2;
        lc753 lc753 = new lc753();
        String s = lc753.crackSafe(n, k);
        System.out.println(lc753.seen);

        System.out.println(s);
    }
}
