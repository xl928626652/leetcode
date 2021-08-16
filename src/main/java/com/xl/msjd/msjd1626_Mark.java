package com.xl.msjd;

import java.util.Stack;

/**
 * @ClassName : msjd1602
 * @Author : Xulian
 * @Date : 2020/10/9 10:44
 */
public class msjd1626_Mark {
    public int calculate(String s) {
        char[] cs = s.trim().toCharArray();
        Stack<Integer> st = new Stack();
        int ans = 0, i = 0;
        while(i < cs.length){
            if(cs[i] == ' ') {i++;continue;}
            char tmp = cs[i];
            if(tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-'){
                i++;
                while(i < cs.length && cs[i] == ' ') i++;
            }
            int num = 0;
            while(i < cs.length && Character.isDigit(cs[i])){
                num = num * 10 + cs[i] - '0';
                i++;
            }
            switch(tmp){
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = st.pop() * num;
                    break;
                case '/':
                    num = st.pop() / num;
                    break;
                default:
                    break;
            }
            st.push(num);
        }
        while(!st.isEmpty()) ans += st.pop();
        return ans;
    }

    public static void main(String[] args) {
        String s = " a bbb c ";
        char[] cs = s.trim().toCharArray();
        for (char c : cs){
            System.out.println(c);
        }
    }

}
