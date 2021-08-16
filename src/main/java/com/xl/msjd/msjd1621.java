package com.xl.msjd;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1621 {
    //HashSet的contains 时间复杂度很低，大概率O（1）
    public int[] findSwapValues(int[] array1, int[] array2) {
        Set<Integer> set = new HashSet<>();
        int s = 0;
        for(int i : array1)
            s += i;
        for(int i : array2){
            s -= i;
            set.add(i);
        }
        if(s % 2 != 0)
            return new int[]{};
        for(int i : array1){
            if(set.contains(i - s/2))
                return new int[]{i , i - s/2};
        }
        return new int[]{};
    }

//    作者：peng-fan-2
//    链接：https://leetcode-cn.com/problems/sum-swap-lcci/solution/qing-chu-by-peng-fan-2/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//    public int[] findSwapValues(int[] array1, int[] array2) {
//        int sum1 = 0, sum2 = 0;
//        for (int i : array1) {
//            sum1 += i;
//        }
//        for (int i : array2) {
//            sum2 += i;
//        }
//        if(((sum1+sum2) & 1) != 0) return new int[0];
//        for (int i = 0; i < array1.length; i++) {
//            for (int j = 0; j < array2.length; j++) {
//                if ((array1[i] - array2[j]) * 2 == sum1 - sum2) {
//                    return new int[]{array1[i], array2[j]};
//                }
//            }
//        }
//        return new int[0];
//    }
}
