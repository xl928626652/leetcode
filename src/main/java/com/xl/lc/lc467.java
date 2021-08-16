package com.xl.lc;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName : lc467
 * @Author : Xulian
 * @Date : 2020/12/3 20:06
 */
public class lc467 {
//    public int findSubstringInWraproundString(String p) {
//        int[] dp = new int[26];
//        Deque<Character> stk = new LinkedList<>();
//        int res = 0;
//        for (int i = 0; i < p.length(); i++) {
//            if (stk.isEmpty()) {
//                stk.offerLast(p.charAt(i));
//                dp[p.charAt(i) - 'a'] = 1;
//                res++;
//                continue;
//            }
//            if ((stk.peekLast() - p.charAt(i) + 26) % 26 == 25) {
//                if (dp[p.charAt(i) - 'a'] == 0) {
//                    res += stk.size() + 1;
//                    dp[p.charAt(i) - 'a'] = stk.size() + 1;
//                } else if (dp[p.charAt(i) - 'a'] < stk.size() + 1) {
//                    res += (stk.size() + 1 - dp[p.charAt(i) - 'a']);
//                    dp[p.charAt(i) - 'a'] = stk.size() + 1;
//                }
//                stk.offerLast(p.charAt(i));
//            } else {
//                while (!stk.isEmpty()) stk.pollFirst();
//                stk.offerLast(p.charAt(i));
//                if (dp[p.charAt(i) - 'a'] == 0) {
//                    res++;
//                    dp[p.charAt(i) - 'a']++;
//                }
//            }
//
//        }
//        return res;
//    }

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int size = 0;
        char last = '0';
        int res = 0;
        for (int i = 0; i < p.length(); i++) {
            if (size == 0) {
                last = p.charAt(i);
                size++;
                dp[p.charAt(i) - 'a'] = 1;
                res++;
                continue;
            }
            if ((last - p.charAt(i) + 26) % 26 == 25) {
                if (dp[p.charAt(i) - 'a'] == 0) {
                    res += size + 1;
                    dp[p.charAt(i) - 'a'] = size + 1;
                } else if (dp[p.charAt(i) - 'a'] < size + 1) {
                    res += (size + 1 - dp[p.charAt(i) - 'a']);
                    dp[p.charAt(i) - 'a'] = size + 1;
                }
                size++;
                last = p.charAt(i);
            } else {
                last = p.charAt(i);
                size = 1;
                if (dp[p.charAt(i) - 'a'] == 0) {
                    res++;
                    dp[p.charAt(i) - 'a']++;
                }
            }
        }
        return res;
    }
}
