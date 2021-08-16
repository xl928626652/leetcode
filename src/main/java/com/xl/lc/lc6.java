package com.xl.lc;

/**
 * @ClassName : lc6
 * @Author : Xulian
 * @Date : 2020/11/12 17:05
 */
public class lc6 {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            StringBuilder tmp = new StringBuilder();
            int first = i;
            int second = 2 * (numRows - 1)  - i;
            if ((second - first) % (2 * (numRows - 1)) != 0){
                while (first < s.length() || second < s.length()){
                    if(first < s.length()) tmp.append(s.charAt(first));
                    if(second < s.length()) tmp.append(s.charAt(second));
                    first += 2 * (numRows - 1);
                    second += 2 * (numRows - 1);
                }
                sb.append(tmp);
            }else{
                while (first < s.length()){
                    tmp.append(s.charAt(first));
                    first += 2 * (numRows - 1);
                }
                sb.append(tmp);
            }
        }
        return sb.toString();
    }
}
