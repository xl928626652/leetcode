package com.xl.jzoffer;

public class JZoffer_05 {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        //char的时间更短
        for (Character c : s.toCharArray())
        {
            if(c==' ') stringBuilder.append("%20");
            else stringBuilder.append(c);
        }
        return stringBuilder.toString();

    }
}
