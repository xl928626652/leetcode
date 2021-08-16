package com.xl.lc;

import java.util.*;

/**
 * @ClassName : lc638
 * @Author : Xulian
 * @Date : 2021/2/26 14:16
 */
public class lc638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        return memSearch(price, special, needs, map);
    }

    public int memSearch(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> map) {
        if (map.containsKey(needs)) {
            return map.get(needs);
        }
        int res = 0;
        for (int i = 0; i < needs.size(); i++) {
            res += needs.get(i) * price.get(i);
        }
        for (List<Integer> spe : special) {
            List<Integer> modified = new ArrayList<Integer>(needs);
            int index = needs.size();
            for (int i = 0; i < needs.size(); i++) {
                int diff = modified.get(i) - spe.get(i);
                if (diff < 0) {
                    index = i;
                    break;
                }
                modified.set(i, diff);
            }
            if (index == needs.size()) {
                res = Math.min(res, memSearch(price, special, modified, map) + spe.get(index));
            }
        }
        map.put(needs, res);
        return res;
    }

    public static void main(String[] args) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list2.add(1);
        map.put(list1, 1);
        System.out.println(map.containsKey(list2));
        Set<Integer> set = new HashSet<>();
        String[] strs = "1::1".split(":");
        System.out.println(Arrays.toString(strs));
        char c = '1';
        boolean b = Character.isAlphabetic('0');
//        Character.isUpperCase()
        String IP = ":123123:";
        String[] ss = IP.split(":", -1);
        System.out.println(Arrays.toString(ss));

    }
}
