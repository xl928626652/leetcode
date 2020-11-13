package com.xl.msjd;

/**
 * @ClassName : msjd1701
 * @Author : Xulian
 * @Date : 2020/10/22 10:49
 */
public class msjd1719 {
    //a & -a 就是得到最低位1的方法。
    //因为两个不同的数一定有一位不一样，所以num1 ^ num2 肯定有一位是1，我们就用a & -a这种方式把这个1弄出来，其实随便搞个1就行，这里就取最低位的1
    //现在找出来后，就把所有的数对这个onePosition求异或，因为一共有2n-2个偶数对，还有2个奇数的，所以就很明显了，偶数对一定会在一个ans里进行异或抵消，最后剩下的ans1和ans2一定是那两个单独的。
    public int[] missingTwo(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
            sum ^= (i + 1);
        }
        sum ^= nums.length + 1;
        sum ^= nums.length + 2;
        int onePosition = sum & -sum;
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i < nums.length + 2; i++) {
            if (i < nums.length && (((onePosition ^ (nums[i])) & onePosition) == onePosition)) {
                ans1 ^= nums[i];
            }
            if (i < nums.length && (((onePosition ^ (nums[i])) & onePosition) != onePosition)) {
                ans2 ^= nums[i];
            }
            if ((((onePosition ^ (i + 1)) & onePosition) == onePosition)) {
                ans1 ^= i + 1;
            }
            if ((((onePosition ^ (i + 1)) & onePosition) != onePosition)) {
                ans2 ^= i + 1;
            }
        }
        return new int[]{ans1, ans2};
    }

    public static void main(String[] args) {
        new msjd1719().missingTwo(new int[]{1});
    }
}
