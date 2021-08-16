package com.xl.lc;

import com.xl.competition.test;

import java.util.*;

/**
 * @ClassName : lcweekly_20201220
 * @Author : Xulian
 * @Date : 2020/12/20 16:34
 */
public class lcweekly_20201220 {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int left = 0, right = 1, max = nums[0];
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        while (right < n) {
            if (set.contains(nums[right])) {
                for (int i = left; i < right; i++) {
                    set.remove(nums[i]);
                    if (nums[i] == nums[right]) {
                        left = i + 1;
                        break;
                    }
                }
            }
            set.add(nums[right]);
            right++;

            max = Math.max(max, pre[right] - pre[left]);

        }
        return max;
    }

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        int[] dp = new int[n];
        dp[0] = nums[0];
        queue.offer(0);
        for (int i = 1; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekFirst() + k < i) {
                queue.pollFirst();
            }
            dp[i] = dp[queue.peekFirst()] + nums[i];
            while (!queue.isEmpty() && dp[queue.peekLast()] < dp[i]) {
                queue.pollLast();
            }
            queue.offer(i);
        }
        return dp[n - 1];
    }

    int[] parent;

    public int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        parent[rootQ] = rootP;
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            map.put(queries[i], i);
        }
        Arrays.sort(edgeList, Comparator.comparingInt(o -> o[2]));
        Arrays.sort(queries, Comparator.comparingInt(o -> o[2]));
        int index = 0;
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            while (index < edgeList.length && edgeList[index][2] < queries[i][2]) {
                union(edgeList[index][0], edgeList[index][1]);
                index++;
            }
            ans[map.get(queries[i])] = find(queries[i][0]) == find(queries[i][1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arrs = new int[]{10000, 1, 10000, 1, 1, 1, 1, 1, 1};
        int res = new lcweekly_20201220().maximumUniqueSubarray(arrs);
        System.out.println(res);
    }
}
