package com.hsc.method;

public class Demo1 {
    public static void main(String[] args) {
        getMax(2,7,4,3,10,1);
    }

    private static void getMax(int ...nums) {
        int len = nums.length;
        int max = nums[0];
        for (int num : nums) {
            max = max > num ? max:num;
        }
        System.out.println(max);
    }
}
