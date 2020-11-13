package com.xl.jzoffer;

import java.util.Arrays;

public class JZoffer_45 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }

    public static void main(String[] args) {
        String a="1";
        String b="2";
        System.out.println((a+b).compareTo(b+a));
    }
}
