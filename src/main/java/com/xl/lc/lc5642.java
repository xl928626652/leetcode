package com.xl.lc;

import java.util.*;

/**
 * @ClassName : lc5642
 * @Author : Xulian
 * @Date : 2021/1/3 15:24
 */
public class lc5642 {
    public int countPairs(int[] deliciousness) {
        //事先把2的幂次都保存在一个数组中，题目说美味度数组最大就是2的20次方
        //所以他们所能达到的幂次也不过就是2的21次方，而最低是1,所以从2的0到2的21次方，一共保存22个数
        int[] mi = new int[22];
        int base = 1;
        for (int i = 0; i < mi.length; i++) {
            mi[i] = base;
            base *= 2;
        }
        //保存每个美味程度的个数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; i++) {
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        long ans = 0;
        int mod = (int) 1e9 + 7;
        //保存美味程度，并且可以在用了一个之后删掉它，避免重复计算。
        Set<Integer> set = new HashSet<>();
        for (int i : deliciousness) set.add(i);

        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = 0; j < mi.length && set.contains(deliciousness[i]); j++) {
                if (mi[j] >= deliciousness[i] && set.contains(mi[j] - deliciousness[i])) {
                    if (deliciousness[i] == mi[j] - deliciousness[i]) {
                        long n = map.get(deliciousness[i]);//这里要开成long,否则68样例测试可以过，提交过不了
                        ans += n * (n - 1) / 2;
                        ans %= mod;
                    } else {
                        ans += map.get(deliciousness[i]) * map.get(mi[j] - deliciousness[i]);
                        ans %= mod;
                    }
                }
            }
            set.remove(deliciousness[i]);
        }
        return (int) ans;

    }

    public static void main(String[] args) {
        int n = 10000000;
        long b = (long) (n * n);
        System.out.println(b);
        int k = 1;
        long c = (int) k;
    }
}
