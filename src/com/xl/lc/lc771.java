package com.xl.lc;

/**
 * @ClassName : lc771
 * @Author : Xulian
 * @Date : 2020/10/2 14:24
 */
public class lc771 {
    public int numJewelsInStones(String J, String S) {
        int[] ints = new int[100];
        for(int i = 0 ; i< J.length();i++){
            ints[J.charAt(i)-'A'] = 1;
        }
        int res = 0;
        for(int i = 0;i<S.length();i++){
            if(ints[S.charAt(i)-'A']!=0){
                ints[S.charAt(i)-'A']++;
            }
        }
        for(int i : ints){
            res+=i;
        }
        return res - J.length();
    }
    public static void main(String[] args) {

        System.out.println(new lc771().numJewelsInStones("z","ZZ"));
    }
}
