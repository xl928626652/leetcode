package com.xl.weekcontest;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class weekly20231028 {

    public static int sumCounts(List<Integer> nums) {
        int sum = 0;
        int mod = 1000000007;
        for (int i = 0; i < nums.size(); i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < nums.size(); j++) {
                set.add(nums.get(j));
                sum += set.size() * set.size();
                sum %= mod;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,2,3,4,5);
        int i = sumCounts(list);
        System.out.println(i);
    }
}
