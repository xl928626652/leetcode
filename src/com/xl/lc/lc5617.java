package com.xl.lc;

/**
 * @ClassName : lc5617
 * @Author : Xulian
 * @Date : 2020/12/6 20:37
 */
public class lc5617 {
    public String interpret(String command) {

//        command = command.replace("()","o");
//        command = command.replace("(al)","al");
        return command.replace("()", "o").replace("(al)", "al");
    }
}
