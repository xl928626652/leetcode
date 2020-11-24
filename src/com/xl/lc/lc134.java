package com.xl.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : lc134
 * @Author : Xulian
 * @Date : 2020/11/18 11:59
 */
public class lc134 {
    Map<Integer, int[]> mem;

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        mem = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            int ti = i;
            int sum = 0;
            int len = 0;
            sum = sum + gas[i] - cost[i];
            if (sum < 0) continue;
            while (sum >= 0 && len <= n) {
                if (mem.containsKey(ti)) {
                    sum += mem.get(ti)[1];
                    len += mem.get(ti)[2] - 1;
                    ti = mem.get(ti)[0];
                    continue;
                }
                len++;
                ti = (ti + 1) % n;
                sum += (gas[ti] - cost[ti]);
            }
            if (len >= n + 1) {
                return i;
            } else {
                mem.put(i, new int[]{ti, sum, len});
            }


        }
        return -1;
    }
}
