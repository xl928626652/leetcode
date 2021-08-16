package com.xl.alibaba.SingleTon;

/**
 * @ClassName : EnumSingltTon
 * @Author : Xulian
 * @Date : 2021/3/20 15:34
 */
public enum EnumSingltTon {
    INSTANCE;
    //枚举绝对防止多次实例化，因为反射创建对象不能破坏枚举
//    public void whateverMethod() {
//    }

}
