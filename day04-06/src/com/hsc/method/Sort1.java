package com.hsc.method;

public class Sort1 {
    public static void main(String[] args) {
        int[] array = sortArray(5, 4, 6, 3, 7, 2, 9, 1);
        for (int i : array) {
            System.out.print(i+" ");
        }
    }

    private static int[] sortArray(int...nums) {

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
