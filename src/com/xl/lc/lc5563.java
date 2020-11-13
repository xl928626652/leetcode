package com.xl.lc;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName : lc5563
 * @Author : Xulian
 * @Date : 2020/11/8 15:49
 */
public class lc5563 {
    //    public int maxProfit(int[] inventory, int orders) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        int mod = (int) 1e9 + 7;
//        for (int i : inventory) {
//            priorityQueue.offer(i);
//        }
//        int val = 0;
//        while (priorityQueue.size() != 0 && priorityQueue.peek() != 0 && orders != 0) {
//            int max = priorityQueue.poll();
//            if (priorityQueue.size() == 0) {
//                while (orders > 0) {
//                    val += max;
//                    max--;
//                    val %= mod;
//                    orders--;
//                }
//            }
//            while (priorityQueue.size() > 0 && priorityQueue.peek() <= max && orders != 0) {
//                val += max;
//                max--;
//                val %= mod;
//                orders--;
//            }
//            if (max != 0) {
//                priorityQueue.offer(max);
//            }
//        }
//        return val;
//    }
    public int maxProfit(int[] inv, int orders) {
        Arrays.sort(inv);
        int n = inv.length;
        long ans = 0;
        for (int i = n - 1; i >= 0 && orders > 0; i--) {
            int l = i;
            while (l > 0 && inv[l] == inv[l - 1]) {
                l--;
            }
            int cnt = n - l;
            int use = l == 0 ? inv[l] : inv[l] - inv[l - 1];
            if ((long) use * cnt >= orders) {
                int left = inv[l] - orders / cnt;
                ans += sum(left + 1, inv[l]) * cnt;
                ans += (long) left * (orders % cnt);
                orders = 0;
            } else {
                ans += sum(inv[l - 1] + 1, inv[l]) * cnt;//这道题不用考虑这里l == 0的情况。1 <= orders <= min(sum(inventory[i]), (int)(10e9))
                orders -= (int) (use * cnt);
            }
            i = l;
        }
        int mod = (int) 1e9 + 7;
        return (int) (ans % mod);
    }

    public long sum(long l, long r) {
        return (l + r) * (r - l + 1) / 2;
    }

}
