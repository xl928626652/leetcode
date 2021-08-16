package com.xl.jzoffer;

public class JZoffer_17 {
    public int[] printNumbers(int n) {
        int k=1;
        while(n!=0)
        {
            k *=10;
            n--;
        }
        int[] res = new int[k-1];
        for(int i=0;i<k-1;i++)
        {
            res[i]=i+1;
        }
        return res;
    }
}
