package com.xl.lc;

import com.sun.org.apache.bcel.internal.generic.GOTO;

public class lc_165 {
    public int compareVersion(String version1, String version2) {
        int res=0;
        int solved=0;
        String[] strings_1=version1.trim().split("\\.");
        String[] strings_2=version2.trim().split("\\.");
        int length=Math.min(strings_1.length,strings_2.length);
        for (int i = 0; i < length; i++) {
            int a=Integer.parseInt(strings_1[i]);
            int b=Integer.parseInt(strings_2[i]);
            if(a<b){
                res=-1;
                solved=1;
                break;
            }else if (a>b){
                res=1;
                solved=1;
                break;
            }
        }
        if(strings_1.length>length && solved==0){
            for (int i = length; i < strings_1.length; i++) {
                if(Integer.parseInt(strings_1[i])!=0)
                    res=1;
            }
        }
        if(strings_2.length>length && solved==0){
            for (int i = length; i < strings_2.length; i++) {
                if(Integer.parseInt(strings_2[i])!=0)
                    res=-1;
            }
        }

        return res;
    }
}
