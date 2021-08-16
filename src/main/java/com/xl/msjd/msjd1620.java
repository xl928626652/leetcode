package com.xl.msjd;

import java.util.*;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1620 {
    //很僵硬
    public List<String> getValidT9Words(String num, String[] words) {
        Map<Character, Character> map = new HashMap<>(26);
        map.put('a', '2');
        map.put('b', '2');
        map.put('c', '2');
        map.put('d', '3');
        map.put('e', '3');
        map.put('f', '3');
        map.put('g', '4');
        map.put('h', '4');
        map.put('i', '4');
        map.put('j', '5');
        map.put('k', '5');
        map.put('l', '5');
        map.put('m', '6');
        map.put('n', '6');
        map.put('o', '6');
        map.put('p', '7');
        map.put('q', '7');
        map.put('r', '7');
        map.put('s', '7');
        map.put('t', '8');
        map.put('u', '8');
        map.put('v', '8');
        map.put('w', '9');
        map.put('x', '9');
        map.put('y', '9');
        map.put('z', '9');
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (int j = 0; j < words[i].length(); j++) {
                if(map.get(words[i].charAt(j))!=num.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                list.add(words[i]);
            }
        }
        return list;
    }
    //dfs是对键盘上的数字按键进行遍历，去匹配String数组里的word，所以复杂度太高
    //如果从String[] 开始着手，就是O（n）时间复杂度。
//    List<String> list;
//    HashSet<String> set;
//
//    public List<String> getValidT9Words(String num, String[] words) {
//        list = new ArrayList<>();
//        String[] strings = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        int[] res = new int[num.length()];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = num.charAt(i) - '2';
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        set = new HashSet<>(Arrays.asList(words));
//        recur(strings, stringBuilder, 0, res);
//
//        return list;
//    }
//
//    public void recur(String[] strings, StringBuilder stringBuilder, int num, int[] res) {
//        if (num == res.length) {
//            if (set.contains(stringBuilder.toString())) {
//                list.add(stringBuilder.toString());
//            }
//            return;
//        }
//        boolean flag = false;
//        for (String i : set) {
//            if (i.contains(stringBuilder.toString())) {
//                flag = true;
//            }
//        }
//        if (flag == false) return;
//        for (int i = 0; i < strings[res[num]].length(); i++) {
//            stringBuilder.append(strings[res[num]].charAt(i));
//            recur(strings, stringBuilder, num + 1, res);
//            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//        }
//    }

}
