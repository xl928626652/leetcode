package com.xl.msjd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1715_Mark {
    //递归法
//    public String longestWord(String[] words) {
//        Arrays.sort(words, (o1, o2) -> o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length());
//        Set<String> set = new HashSet<>(Arrays.asList(words));
//        for (String word : words) {
//            set.remove(word);
//            if (find(set, word)) {
//                return word;
//            }
//        }
//        return "";
//    }
//
//    public boolean find(Set<String> set, String word) {
//        if (word.length() == 0) {
//            return true;
//        }
//        for (int i = 0; i < word.length(); i++) {
//            if (set.contains(word.substring(0, i + 1)) && find(set, word.substring(i + 1))) {
//                return true;
//            }
//        }
//        return false;
//    }



}
