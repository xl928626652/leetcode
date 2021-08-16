package com.xl.lc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class lc_692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> {
            return map.get(o1).equals(map.get(o2)) ? o1.compareTo(o2) : map.get(o2) - map.get(o1);
        });
        return list.subList(0, k);
    }

    public static void main(String[] args) {
        String[] words = new String[]{"i", "lb", "la", "i"};
        int k = 2;
        List<String> list = new lc_692().topKFrequent(words, k);
        for(String s: list){
            System.out.println(s);
        }

    }
}
