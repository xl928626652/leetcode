package com.xl.lc;

import java.util.*;

/**
 * @ClassName : lc403
 * @Author : Xulian
 * @Date : 2020/12/2 20:19
 */
public class lc403 {
    public boolean canCross(int[] stones) {
        Deque<int[]> stk = new LinkedList<>();
        int n = stones.length;
        int end = stones[n - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i < n; i++) {
            set.add(stones[i]);
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> setTmp = new HashSet<>();
        setTmp.add(1);
        map.put(1, setTmp);
        if (stones[1] != 1) return false;
        stk.offerLast(new int[]{1, 1});//因为一开始会从0跳到1，所以直接把1和1放入栈，int[0]代表跳了k步后到达的stone位置，int[1]表示k步。比如从0跳到1,到达的位置为1，跳了1步，就是new int[]{1,1}
        while (!stk.isEmpty()) {
            int[] cur = stk.pollFirst();
            int curStone = cur[0], k = cur[1];
            if (curStone > end) continue;
            else if (curStone == end) {
                return true;
            } else {
                if (set.contains(curStone + k - 1) && k != 1) {
                    Set<Integer> set1 = map.getOrDefault(curStone + k - 1, new HashSet<Integer>());
                    if (!set1.contains(k - 1)) {
                        set1.add(k - 1);
                        stk.offerLast(new int[]{curStone + k - 1, k - 1});
                        map.put(curStone + k - 1, set1);
                    }
                }
                if (set.contains(curStone + k)) {
                    Set<Integer> set2 = map.getOrDefault(curStone + k, new HashSet<Integer>());
                    if (!set2.contains(k)) {
                        set2.add(k);
                        stk.offerLast(new int[]{curStone + k, k});
                        map.put(curStone + k, set2);
                    }
                }
                if (set.contains(curStone + k + 1)) {
                    Set<Integer> set3 = map.getOrDefault(curStone + k + 1, new HashSet<Integer>());
                    if (!set3.contains(k + 1)) {
                        set3.add(k + 1);
                        stk.offerLast(new int[]{curStone + k + 1, k + 1});
                        map.put(curStone + k + 1, set3);
                    }
                }

            }
        }
        return false;
    }
}
