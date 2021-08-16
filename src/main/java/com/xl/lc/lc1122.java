package com.xl.lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc1122 {
    //    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : arr1) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        int[] res = new int[arr1.length];
//        int index = 0;
//        for (int i :arr2){
//            while (map.get(i)!=0){
//                res[index++] = i;
//                map.put(i,map.get(i) - 1);
//            }
//            map.remove(i);
//        }
//        int[] keySet = map.keySet().stream().sorted().mapToInt(Integer::valueOf).toArray();
//        for (int i :keySet){
//            while (map.get(i)!=0){
//                res[index++] = i;
//                map.put(i,map.get(i) - 1);
//            }
//            map.remove(i);
//        }
//        return res;
//    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }

    // 作者：LeetCode-Solution
// 链接：https://leetcode-cn.com/problems/relative-sort-array/solution/shu-zu-de-xiang-dui-pai-xu-by-leetcode-solution/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        int[] res = new lc1122().relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }
}
