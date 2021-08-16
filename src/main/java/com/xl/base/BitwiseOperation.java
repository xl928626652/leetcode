package com.xl.base;

public class BitwiseOperation {
    //~
    public void quFan() {
        //二进制数在内存中是以补码的形式存放的。
        //补码首位是符号位,0表示此数为正数,1表示此数为负数。
        //正数的补码、反码,都是其本身。
        //负数的反码是:符号位为1,其余各位求反,但末位不加1 。
        //负数的补码是:符号位不变,其余各位求反,末位加1 。
        int d = 9;
        //因为正数的补码就是自己，所以正数直接开始操作，
        // 取反之后，其实还是补码，
        // 如果取反之后是负数，还要转换成负数的原码才行
        /*00000000 00000000 00000000 00001001
         * ->取反
         * 11111111 11111111 11111111 11110110
         * ->减一
         * 11111111 11111111 11111111 11110101
         * ->符号位不变 数值位取反
         * 10000000 00000000 00000000 00001010*/
        System.out.println(~d);//结果为-10

        int d2 = -9;
        /*10000000 00000000 00000000 00001001
         * ->转补码
         * 11111111 11111111 11111111 11110111
         * ->取反
         * 00000000 00000000 00000000 00001000
         * 因为正数的补码、反码全是原码，
         * 所以负数先转换成补码，然后取反，
         * 这肯定是一个正数，所以这个补码跟原码是一样的
         * */
        System.out.println(~d2);//结果为8
    }

    // >> and >>>
    public void youYi() {
        int d = -4;
        /*为方便 这里(>>) 只用8位
        原码开始
        1000 0100 -> 1111 1011 -> 1111 1100 ->（>>带符号右移，负数高位补1） 1111 1110
        1111 1110负数的补码转原码 -> 1111 1101 -> 1000 0010 也就是-2
        * */
        /*
        * 但是负数的无符号右移，就很麻烦
        * -4 的补码
        * 11111111 11111111 11111111 11111100 -> 01111111 11111111 11111111 11111110
        *因为高位补0了，所以是正数，直接转成原码
        * 01111111 11111111 11111111 11111110
        =2^31 - 2
        * */
        System.out.println(d >> 1); //-2
        System.out.println(d >>> 1); //
        System.out.println(Integer.toBinaryString(d>>>2).length());
        System.out.println(d>>>2);
        System.out.println((1<<30) - 1);
    }

    // ^
    public void yihuo() {
        int a = 1;
        int b = -1;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(a ^ b));
        System.out.println(Integer.bitCount(a));
        System.out.println(Integer.bitCount(b));
        System.out.println(Integer.bitCount(a ^ b));
    }

    public static void main(String[] args) {
        BitwiseOperation bitwiseOperation = new BitwiseOperation();

//        bitwiseOperation.quFan();
        bitwiseOperation.youYi();
//        bitwiseOperation.yihuo();

    }
}
