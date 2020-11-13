package com.xl.jzoffer;

import java.util.HashMap;

public class JZoffer_39 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int len= nums.length;
        for(int index: nums){
            if(!map.containsKey(index)){
                map.put(index,1);
            }else{
                map.replace(index,map.get(index)+1);
                if(map.get(index)> nums.length/2){
                    return index;
                }
            }
        }
        return nums[0];
    }
}
