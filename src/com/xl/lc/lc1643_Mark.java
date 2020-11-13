package com.xl.lc;

import java.util.List;

/**
 * @ClassName : lc1643
 * @Author : Xulian
 * @Date : 2020/11/2 16:10
 */
public class lc1643_Mark {
    //回溯直接gg
//    String finalres;
//    int res;
//    int hnum;
//    int vnum;
//    public String kthSmallestPath(int[] destination, int k) {
//        hnum = destination[1];
//        vnum = destination[0];
//        int length = hnum + vnum;
//        res = 0;
//        StringBuilder stringBuilder = new StringBuilder();
//        recur(k, stringBuilder, length,0, 0);
//        return finalres;
//    }
//
//    public void recur(int k, StringBuilder stringBuilder, int len, int a, int b) {
//        if (stringBuilder.length() == len) {
//            if (a == hnum && b == vnum)
//            {
//                res++;
//            }else{
//                return;
//            }
//            if (res == k) {
//                finalres = stringBuilder.toString();
//                return;
//            }
//            return;
//        }
//        if (stringBuilder.length() > len){
//            return;
//        }
//        if (res > k ) return;
//        stringBuilder.append("H");
//        recur(k, stringBuilder, len,a + 1, b);
//        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//        stringBuilder.append("V");
//        recur(k, stringBuilder, len,a , b + 1);
//        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//    }
    public String kthSmallestPath(int[] destination, int k) {
        //字符"H"的数量
        int h = destination[1];
        //字符"V"的数量
        int v = destination[0];
        StringBuilder sb = new StringBuilder();
        //动态规划求解组合数量，乘法容易溢出
        int[][] dp = new int[h+v][h];
        dp[0][0] = 1;
        for(int i=1;i<h+v;i++){
            dp[i][0] = 1;
            for(int j=1;j<=i&&j<h;j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        //依次求解各个位置的字符
        while(h>0 && v>0){
            int low = dp[h+v-1][h-1];
            if(k>low){
                sb.append("V");
                v--;
                k -= low; //更新k值
            }else{
                sb.append("H");
                h--;
            }
        }
        if(h==0){//如果"H"用完,则把剩余位置都是"V"
            for(int i=0;i<v;i++){
                sb.append("V");
            }
        }else{//如果"V"用完,则剩余位置都是"H"
            for(int i=0;i<h;i++){
                sb.append("H");
            }
        }
        return sb.toString();
    }

//    作者：hello-angel
//    链接：https://leetcode-cn.com/problems/kth-smallest-instructions/solution/javazu-he-shu-qiu-jie-si-lu-fen-xiang-by-hello-ang/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static void main(String[] args) {
//        int[] destination = new int[]{15, 15};
//        int k = 155117520;
//        String s = new lc1643().kthSmallestPath(destination, k);
//        System.out.println(s);

    }
}
