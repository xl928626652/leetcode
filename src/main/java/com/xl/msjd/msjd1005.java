package com.xl.msjd;

/**
 * @ClassName : msjd1005
 * @Author : Xulian
 * @Date : 2020/10/4 18:43
 */
public class msjd1005 {
    public int findString(String[] words, String s) {
        for(int i = 0; i < words.length;i++){
            if(words[i]!="" && words[i].equals(s)){
                return i;
            }
        }
        return -1;
    }
}
