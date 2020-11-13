package com.xl.msjd;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1610 {
    //暴力法
//    public int maxAliveYear(int[] birth, int[] death) {
//        int[] year = new int[101];
//        for (int i = 0; i < birth.length; i++) {
//            for (int begin = birth[i]; begin<death[i]; begin++) {
//                year[begin - 1900]++;
//            }
//        }
//        int max = 0, index = 100;
//        for (int i = 0; i < year.length; i++) {
//            if (year[i] > max) {
//                max = year[i];
//                index = i;
//            }
//        }
//        return index + 1900;
//    }
    //这题是标准的前缀和
    public int maxAliveYear(int[] birth, int[] death) {
        int[] year = new int[102];
        for (int i = 0; i < birth.length; i++) {
            year[birth[i] - 1900]++;
            year[death[i] - 1900 + 1]--;
        }
        int sum = 0;
        int max = 0;
        int index = 0;
        for (int i = 0; i < year.length; i++) {
            sum+=year[i];
            if(sum>max){
                max = sum;
                index = i;
            }
        }
        return index + 1900;
    }
}
