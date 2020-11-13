package com.xl.jzoffer;

public class JZoffer_11 {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        for(int i = 0;i<len-1;i++)
        {
            if(numbers[i+1] < numbers[i])
                return numbers[i+1];
        }
        return numbers[0];
    }
}
