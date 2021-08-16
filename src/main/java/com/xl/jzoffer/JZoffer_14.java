package com.xl.jzoffer;
/*给你一根长度为 n 的绳子，
请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
*/
public class JZoffer_14 {
//    网上答案
//    public int cuttingRope(int n) {
//        if(n <= 3) return n - 1;
//        int a = n / 3, b = n % 3;
//        if(b == 0) return (int)Math.pow(3, a);
//        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
//        return (int)Math.pow(3, a) * 2;
//    }
    //这个代码是自己试出来的，挺尴尬，但其实是有数学原理支撑的
    public int cuttingRope(int n) {
        int max=1;
        if(n==3) return 2;
        for (int i=2;i<n;i++)
        {
            int res=1;
            int temp=n;
            while(temp>0)
            {
                if(temp-i >=0){
                    if(temp==i+1)
                    {
                        res*=temp;
                        temp-=2*i;
                    }else{
                        res*=i;
                        temp-=i;
                    }
                }else{
                    res*=temp;
                    temp-=i;
                }
            }
            if(max<res)max=res;
        }
        return max;
    }
    public static void main(String[] args) {
        JZoffer_14 jZoffer_14 = new JZoffer_14();
        System.out.println(jZoffer_14.cuttingRope(10));
    }
}
