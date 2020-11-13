package com.xl.mianshi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mianshi1707 {
    /*每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性*/
// 这段代码不行，这题并查集需要自己实现，不能直接套以前的。
//    public String[] trulyMostPopular(String[] names, String[] synonyms) {
//        StringBuilder stringBuilder = new StringBuilder();
//        UnionFind unionFind = new UnionFind(names.length);
//        Map<String, Integer> map = new HashMap<>();
//        int[] num = new int[names.length];
//        Pattern pattern = Pattern.compile("(?<=\\()(.+?)(?=\\))");
//        Matcher matcher;
//        for (int i = 0; i < names.length; i++) {
//            matcher = pattern.matcher(names[i]);
//            String tmp = matcher.group();
//            int number = Integer.parseInt(tmp);
//            num[i] = number;
//            map.put(names[i].substring(0, names[i].length() - tmp.length() - 2), i);
//        }
//        List<Integer> list = new ArrayList<>();
//        for (String s : synonyms) {
//            String[] strings = s.trim().substring(1, s.length() - 1).split(",");
//            String a = strings[0], b = strings[1];
//            unionFind.union(map.get(a), map.get(b));
//            String tmp = a.compareTo(b) < 0 ? a : b;
//            map.put(tmp, map.get(a) + map.get(b));
//            map.remove(b);
//        }
//        return null;
//    }
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> unionMap = new HashMap<>();
        for (String name : names) {
            int a = name.indexOf('(');
            int b = name.indexOf(')');
            int value = Integer.parseInt(name.substring(a + 1, b));
            String key = name.substring(0, a);
            map.put(key, value);
        }

        for (String pair : synonyms) {
            int idx = pair.indexOf(',');
            String name1 = pair.substring(1, idx);
            String name2 = pair.substring(idx + 1, pair.length() - 1);
            while (unionMap.containsKey(name1)) {   //找name1祖宗
                name1 = unionMap.get(name1);
            }
            while (unionMap.containsKey(name2)) {   //找name2祖宗
                name2 = unionMap.get(name2);
            }
            //这是核心的构造父-子树的代码，每次都把字典序小的作为根，
            if (!name1.equals(name2)) {
                int number = map.getOrDefault(name1, 0) + map.getOrDefault(name2, 0);
                String trulyName = name1.compareTo(name2) < 0 ? name1 : name2;
                String nickName = name1.compareTo(name2) < 0 ? name2 : name1;
                unionMap.put(nickName, trulyName);      //小名作为大名的分支，即大名是小名的祖宗
                map.remove(nickName);       //更新一下数据
                map.put(trulyName, number);
            }
        }
        String[] res = new String[map.size()];
        int index = 0;
        for (String s : map.keySet()){
            StringBuilder stringBuilder = new StringBuilder(s);
            stringBuilder.append('(');
            stringBuilder.append(map.get(s));
            stringBuilder.append(')');
            res[index++]=stringBuilder.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);

        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }
    }
}
