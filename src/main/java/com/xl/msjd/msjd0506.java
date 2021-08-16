package com.xl.msjd;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

public class msjd0506 {
    //这道题挺麻烦的，注意点：①大整数乘法越界，所以尽量别用A * B这种来判断
    //判断其实
    public int convertInteger(int A, int B) {
        String a = Integer.toBinaryString(A);
        String b = Integer.toBinaryString(B);
        int alen = a.length(), blen = b.length();
        int res = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Math.abs(alen - blen); i++) {
            stringBuilder.append("0");
        }
        if(alen<=blen){
            stringBuilder.append(a);
            res = contrast(stringBuilder.toString(),b);
        }else{
            stringBuilder.append(b);
            res = contrast(stringBuilder.toString(),a);
        }
        return res;
    }
    public int contrast(String a,String b){
        int res = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i)!=b.charAt(i)){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int a= 1527700032;
        int b =1678530761;
        String as = Integer.toBinaryString(a);
        String bs = Integer.toBinaryString(b);
        System.out.println(new msjd0506().contrast(as,bs));
        System.out.println(as + ": " +as.length());
        System.out.println(bs + ": " +bs.length());
    }
}
