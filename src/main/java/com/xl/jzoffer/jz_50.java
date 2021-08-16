package com.xl.jzoffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jz_50 {
    public char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        List<Character> list= new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if(!list.contains(s.charAt(i))) list.add(s.charAt(i));
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (char c : list){
            if(map.get(c)==1) return c;
        }
        return ' ';
    }
}
