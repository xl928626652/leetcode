package com.xl.lc;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : lc3
 * @Author : Xulian
 * @Date : 2020/11/12 17:34
 */
public class lc3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        while(left <= right && right < s.length()){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                max = Math.max(max, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}
