package com.xl.jzoffer;

public class jz_65 {
    //<<表示左移移，不分正负数，低位补0；　
    //>>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；
    //>>>表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0

    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
}
