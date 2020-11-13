package com.xl.lc;

/**
 * @ClassName : lc844
 * @Author : Xulian
 * @Date : 2020/10/19 8:59
 */
public class lc844 {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for(int i = 0;i<S.length();i++){
            if(S.charAt(i)!='#'){
                sb1.append(S.charAt(i));
            }else{
                if(sb1.length()!=0){
                    sb1.deleteCharAt(sb1.length()-1);
                }
            }
        }
        for(int i = 0;i<T.length();i++){
            if(T.charAt(i)!='#'){
                sb2.append(T.charAt(i));
            }else{
                if(sb2.length()!=0){
                    sb2.deleteCharAt(sb2.length()-1);
                }
            }
        }
        return sb1.toString().equals(sb2.toString());
    }
}
