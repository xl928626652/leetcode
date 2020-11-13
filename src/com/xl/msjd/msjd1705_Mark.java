package com.xl.msjd;

import javax.net.ssl.HostnameVerifier;
import java.util.*;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1705_Mark {
    public String[] findLongestSubarray(String[] array) {
        int start = 0, end = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < array.length; i++) {
            sum += Character.isDigit(array[i].charAt(0)) ? 1 : -1;
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            } else {
                int index = map.get(sum);
                if (i - index > end - start) {
                    start = index;
                    end = i;
                }
            }
        }
        String[] res = new String[end - start];
        for (int i = start + 1; i <= end; i++) {
            res[i - start - 1] = array[i];
        }
        return res;
    }
//    public String[] findLongestSubarray(String[] array) {
//        int start = 0;
//        int end = 0;
//        HashMap<Integer, Integer> dataMap = new HashMap<>();
//        int sum = 0;
//        dataMap.put(0, -1);
//        for(int i=0; i<array.length; i++) {
//            sum += Character.isDigit(array[i].charAt(0)) ? 1 : -1;
//            if(!dataMap.containsKey(sum)) {
//                dataMap.put(sum, i);
//            } else {
//                int index = dataMap.get(sum);
//                if(i - index > end - start) {
//                    start = index;
//                    end = i;
//                }
//            }
//        }
//        return Arrays.copyOfRange(array, start + 1, end + 1);
//    }

    public static void main(String[] args) {
        //用linkedHashSet
        Set<Integer> set = new LinkedHashSet<>();
        set.add(1124);
        set.add(2124);
        set.add(3124);
        set.add(4124);
        set.add(5124);
        set.add(6412);
        set.add(7124);
        set.add(8124);
        set.add(9124);
        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
