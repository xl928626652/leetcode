package com.xl.msjd;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1602 {

    class WordsFrequency {
        Map<String, Integer> map;

        public WordsFrequency(String[] book) {
            map = new HashMap<>();
            for (String i : book) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }

        public int get(String word) {
            return map.getOrDefault(word, 0);
        }
    }
}
