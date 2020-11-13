package com.xl.jzoffer;

public class JZoffer_44_Qiaomiao {
    //超时
    public int findNthDigit(int n) {
        int count=-1;
        int temp;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            count++;
            if(count==n && i<10) return i;
            temp=i;
            int temp_temp=count;
            int temp_count=count;
            while(temp/10!=0 ){
                temp/=10;
                temp_count++;
                count++;
            }
            int p=temp_count-n;
            if(p>=0){
                char res=Integer.toString(i).charAt(n-temp_temp);
                String s=new String(String.valueOf(res));
                return Integer.parseInt(s);
            }
        }
        return 0;
    }
    public int findNthDigit_K(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
    public static void main(String[] args) {
        JZoffer_44_Qiaomiao jZoffer_44=new JZoffer_44_Qiaomiao();
        int res=jZoffer_44.findNthDigit(10000);
        int res_K=jZoffer_44.findNthDigit_K(10000);
        System.out.println(res+":"+res_K);
        char c='2';
        String s=String.valueOf(c);
        System.out.println(s);
    }
}
