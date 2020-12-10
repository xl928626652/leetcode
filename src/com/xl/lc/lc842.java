package com.xl.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName : lc842
 * @Author : Xulian
 * @Date : 2020/12/8 14:10
 */
public class lc842 {
    List<Integer> ans;
    boolean flag;

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        ans = new ArrayList<>();
        flag = false;
        dfs(S, 0, list);
        return ans;
    }

    public void dfs(String S, int start, List<Integer> list) {
        if (!flag && start == S.length() && list.size() >= 3) {
            flag = true;
            ans = new ArrayList<>(list);
        }
        if (!flag && start >= S.length()) return;
        if (!flag && S.charAt(start) == '0') {
            if (list.size() < 2 || list.get(list.size() - 2) + list.get(list.size() - 1) == 0) {
                list.add(0);
                dfs(S, start + 1, list);
                list.remove(list.size() - 1);
            }
        } else {
            for (int i = start; i <= start + 11 && i < S.length() && !flag; i++) {
                long a = Long.parseLong(S.substring(start, i + 1));
                if (a <= Integer.MAX_VALUE) {
                    if (list.size() < 2 || list.get(list.size() - 2) + list.get(list.size() - 1) == a) {
                        list.add((int) (a));
                        dfs(S, i + 1, list);
                        list.remove(list.size() - 1);
                    } else if (list.get(list.size() - 2) + list.get(list.size() - 1) < a) {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new lc842().splitIntoFibonacci("123456");
        int[] res = list.stream().sorted().mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(res));
    }
}
