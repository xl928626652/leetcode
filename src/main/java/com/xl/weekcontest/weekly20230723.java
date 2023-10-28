package com.xl.weekcontest;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class weekly20230723 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.size() == 0) return ans;
//        String sep = String.valueOf(separator);
        for (String s : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == separator) {
                    String cur = sb.toString();
                    if (!cur.isEmpty()) {
                        ans.add(cur);
                    }
                    sb = new StringBuilder();
                } else {
                    sb.append(c);
                }
            }
            if (!sb.toString().isEmpty()) {
                ans.add(sb.toString());
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
