package com.xl.jzoffer;


import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //01test
    int a = 0;

    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void test() {
        this.a = 10;
    }

    //02test
    public boolean exist(int a) {
        int res = dfs(a);
        return true;
    }

    public int dfs(int a) {
        a++;
        if (a == 8)
            return 0;
        dfs(a);
        a--;
        return a;
    }

    public void print(List<Integer> list) {
        for (int i : list) {
            System.out.println(i);
        }
    }
    public boolean isSpecialChar(String str) {
        // String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        String regEx = "[ _.`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            boolean size= s.length() >= 8;
            boolean lower = false;
            boolean upper = false;
            boolean special = main.isSpecialChar(s);
            boolean number = false;
            for (int i = 0; i < chars.length; i++) {
                char a = chars[i];
                if (Character.isLowerCase(a)) lower = true;
                if (Character.isUpperCase(a)) upper = true;
                if (Character.isDigit(a)) number = true;
            }
            if(size && lower && upper && special && number){
                System.out.println("Ok");
            }else{
                System.out.println("Irregular password");
            }

        }

    }



}
