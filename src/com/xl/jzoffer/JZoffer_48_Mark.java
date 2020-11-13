package com.xl.jzoffer;


import java.util.*;

public class JZoffer_48_Mark {
    //很慢很耗时的写法
    /*public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 0) return 0;
        Deque<Character> queue = new LinkedList<>();
        int left = 0, right = 0;
        queue.add(s.charAt(right++));
        int res = 1;
        while (right < s.length()) {
            if (!queue.contains(s.charAt(right))) {
                queue.add(s.charAt(right));
                res = Math.max(right - left + 1, res);
                right++;
            } else {
                while (queue.contains(s.charAt(right))) {
                    queue.removeFirst();
                    left++;
                }
            }
        }
        return res;
    }*/
    //这个稍微快点
    /*public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int temp = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = map.getOrDefault(s.charAt(i), -1);
            if (temp < i - index) {
                temp = temp + 1;
            } else {
                temp = i - index;
            }
            res = Math.max(res, temp);
            map.put(s.charAt(i), i);
        }
        return res;
    }*/
    //这个方法好，java也可以像python一样，用 in的这种方式写
    public int lengthOfLongestSubstring(String s) {
        int head = 0;
        int tail = 0;
        if(s.length() < 2) return s.length();
        int res = 1;
        while(tail < s.length()-1){
            tail++;
            //如果不包含当前字符，就更新最长的长度
            if(!s.substring(head,tail).contains(s.substring(tail,tail+1))){
                res = Math.max(tail- head + 1,res);
            }
            //如果包含的话，更新头指针
            else {
                while(s.substring(head,tail).contains(s.substring(tail,tail+1))){
                    head++;
                }
            }
        }
        return res;
    }



}
