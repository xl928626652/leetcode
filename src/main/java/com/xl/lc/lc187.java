package com.xl.lc;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author：xulian-lmhmac
 * @name：lc187
 * @Date：2023/11/5 12:27 周日
 */
public class lc187 {
    //    public static List<String> findRepeatedDnaSequences(String s) {
//        Map<String, Integer> map = new HashMap<>();
//        int len = 10;
//        StringBuilder sb = new StringBuilder(10);
//        for (int i = 0; i < s.length(); i++) {
//            if (sb.length() < len) {
//                sb.append(s.charAt(i));
//            }
//            if (sb.length() == 10) {
//                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
//                sb.delete(0, 1);
//            }
//        }
//        return map.entrySet().stream()
//                .filter(entry -> entry.getValue() > 1)
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList());
//    }
    static Map<Character, Integer> classMap = new HashMap<Character, Integer>(){
        {put('A',0);}
        {put('C',1);}
        {put('G',2);}
        {put('T',3);}
    };
    public static List<String> findRepeatedDnaSequences(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int x = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            x = x + classMap.get(s.charAt(i));
            if (i < 9) {
                x = x << 2;
                continue;
            }
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == 2) {
                list.add(s.substring(i - 9, i + 1));
            }
            x = (x << 2) & ((1 << 20) - 1);
        }
        return list;
    }

    /**
     * 这里是把x的二进制位数往左移20格
     * @param x
     * @return
     */
    private static int get20lowBit(int x) {
        int i = Integer.MAX_VALUE;
        int mask1 = 1 << 20 - 1;
        int maskx = 1 << 19;
        int mask2 = (1 << 20) - 1;
        int masky = 1 << 0;
        int maskz = 1 << 1;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(maskx));
        System.out.println(Integer.toBinaryString(masky));
        System.out.println(Integer.toBinaryString(maskz));
        System.out.println(Integer.toBinaryString(mask1));
        System.out.println(Integer.toBinaryString(mask2));
        System.out.println(i + ":" + mask1);
        return i & mask1;
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> repeatedDnaSequences = findRepeatedDnaSequences(s);
        System.out.println(repeatedDnaSequences);

    }
}
