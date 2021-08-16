package com.xl.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : lc5640
 * @Author : Xulian
 * @Date : 2020/12/27 20:05
 */
public class lc5640 {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    class Solution {
        public int[] maximizeXor(int[] nums, int[][] queries) {
            Arrays.sort(nums);
            Arrays.sort(queries, (o1, o2) -> {
                return o1[1] - o2[1];
            });
            int max = Arrays.stream(nums).max().getAsInt();
            for (int i = 0; i < queries.length; i++) {
                max = Math.max(max, queries[i][1]);
            }
            int maxL = Integer.toBinaryString(max).length();

            int n = nums.length, m = queries.length;
            int index = 0;
            int[] ans = new int[m];
            TrieNode root = new TrieNode();
            for (int i = 0; i < m; i++) {
                TrieNode tmpRoot = root;
                while (index < n && nums[index] <= queries[i][1]) {
                    TrieNode curRoot = root;
                    String cur = Long.toBinaryString((long) (1 << maxL) | (long) nums[index]).substring(1);
                    for (char c : cur.toCharArray()) {
                        if (curRoot.children.containsKey(c)) {
                            curRoot = curRoot.children.get(c);
                        } else {
                            TrieNode gen = new TrieNode();
                            curRoot.children.put(c, gen);
                            curRoot = gen;
                        }
                    }
                    index++;
                }
                String s = Long.toBinaryString((long) (1 << maxL) | (long) queries[i][0]).substring(1);
                int maxXor = -1;
                for (char c : s.toCharArray()) {
                    char toggledChar = c == '0' ? '1' : '0';
                    if (tmpRoot.children.containsKey(toggledChar)) {
                        maxXor = (maxXor << 1) + 1;
                        tmpRoot = tmpRoot.children.get(toggledChar);
                    } else {
                        if (!tmpRoot.children.containsKey(c)) {
                            maxXor = -1;
                            break;
                        } else {
                            maxXor = (maxXor << 1);
                            tmpRoot = tmpRoot.children.get(c);
                        }

                    }
                }
                ans[m] = maxXor;
            }
            return ans;
        }

    }
}
