package com.xl.msjd;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class msjd0101 {
    //    public boolean isUnique(String astr) {
    //        Set<Character> set = new HashSet<>();
    //        for (int i = 0; i < astr.length(); i++) {
    //            char cur = astr.charAt(i);
    //            if(set.contains(cur)){
    //                return false;
    //            }else {
    //                set.add(cur);
    //            }
    //        }
    //        return true;
    //    }

    //位运算
    public boolean isUnique(String astr) {
        int flag = 0;
        for (int i = 0; i < astr.length(); i++) {
            int a = 1 << astr.charAt(i) - 'a';
            if((a & flag) !=0){
                return false;
            }else{
                flag |= a;
            }
        }
        return true;
    }
}
