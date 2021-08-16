package com.xl.lc;

import java.util.*;

/**
 * @ClassName : lc5562
 * @Author : Xulian
 * @Date : 2020/11/8 15:49
 */
public class lc5562_Mark {

    public int minDeletions(String s) {
        int[] cnt = new int[26];
        for(char c : s.toCharArray()){
            cnt[c - 'a']++;
        }
        Set<Integer> set = new HashSet();
        int ans = 0;
        for(int x : cnt){
            if(x > 0){
                while(x > 0 && set.contains(x)){
                    x--;
                    ans++;
                }
                set.add(x);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet();
        set.add(0);
        set.add(0);
        set.add(1);
        set.forEach(System.out::println);
    }
}
