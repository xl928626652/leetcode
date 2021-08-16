package com.xl.msjd;

import java.util.Arrays;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1606 {
    public int smallestDifference(int[] a, int[] b) {
        int min = Math.abs(Math.abs(a[0]) - Math.abs(b[0]));
        Arrays.sort(a);
        Arrays.sort(b);
        if (a.length < 2 || b.length < 2) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    min = Math.min(min, Math.abs(Math.abs(a[i]) - Math.abs(b[j])));
                }
            }
            return min;
        }

        int aIndex = 1, bIndex = 0;
        while (aIndex < a.length && bIndex < b.length) {
            int dif1 = Math.abs(Math.abs(a[aIndex - 1]) - Math.abs(b[bIndex]));
            int dif2 = Math.abs(Math.abs(a[aIndex]) - Math.abs(b[bIndex]));
            if(Math.min(dif1,dif2) <0){
                if(dif1>=0){
                    min = Math.min(min,dif1);
                }
                if(dif2>=0){
                    min = Math.min(min,dif2);
                }
                aIndex++;
                continue;
            }
            min = Math.min(min, Math.min(dif1, dif2));
            if (dif1 >= dif2) {
                aIndex++;
            } else {
                bIndex++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int x = Integer.MIN_VALUE;
        System.out.println(Math.abs(x)- Math.abs(Integer.MAX_VALUE));
        System.out.println(Math.abs(Integer.MIN_VALUE));
    }
}
