package com.xl.lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : lc5635
 * @Author : Xulian
 * @Date : 2021/1/10 22:22
 */
public class lc5635 {
    Set<Integer> set = new HashSet<>();
    int[] ans;

    public int[] constructDistancedSequence(int n) {
        int size = 2 * n - 1;
        ans = new int[size];
        dfs(0, n, size);
        return ans;
    }

    public boolean dfs(int start, int n, int size) {
        if (set.size() == n) {
            return true;
        } else {
            if (ans[start] != 0) {
                return dfs(start + 1, n, size);
            } else {
                for (int i = n; i > 0; i--) {
                    if (set.contains(i)) continue;
                    if (i == 1 || (i + start < size && ans[i + start] == 0)) {
                        set.add(i);
                        ans[start] = i;
                        if (i != 1) {
                            ans[start + i] = i;
                        }
                        boolean flag = dfs(start + 1, n, size);
                        if (flag) return true;

                        set.remove(i);
                        ans[start] = 0;
                        if (i != 1) {
                            ans[start + i] = 0;
                        }

                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int num = 17;
        int[] ans = new lc5635().constructDistancedSequence(num);
        System.out.println(Arrays.toString(ans));
    }
}
