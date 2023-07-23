package com.xl.weekcontest;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class weekly20230723 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.size() == 0) return ans;
        String c = String.valueOf(separator);
        for (String s : words) {
            String[] strs = s.split(c);
            for (int i = 0; i < strs.length; i++) {
                ans.add(strs[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> words = Lists.newArrayList("one.two.three","four.five","six");
        char separator = '.';
        List<String> strings = new weekly20230723().splitWordsBySeparator(words, separator);
        System.out.println(strings);
    }
}
