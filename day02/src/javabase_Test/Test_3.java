package javabase_Test;

import java.util.Arrays;
import java.util.Random;

public class Test_3 {
    public static void main(String[] args) {
        // 3个的数组
        int r1 = new Random().nextInt(5)+1;
        int r2=new Random().nextInt(5)+1;
        int[] arr1 = new int[r1];
        int[] arr2 = new int[r2];
        int[] plus = new int[r1 + r2];
        // 第一个数组 arr1
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = new Random().nextInt(100)+1;
            plus[i] = arr1[i];
        }
        // 第二个数组
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = new Random().nextInt(100)+1;
            plus[i+arr1.length] = arr2[i];
        }
        // 输出数组
        System.out.println("合并数组之前数组的元素:");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr1.length; i++) {

            if(i==(arr1.length-1)){
                sb.append(arr1[i]+"]");
            }else{
                sb.append(arr1[i]+", ");
            }
        }
        System.out.println("arr1的元素:"+sb.toString());
        System.out.println("arr2的元素:"+Arrays.toString(arr2));
        System.out.println("合并后数组的元素:"+Arrays.toString(plus));
    }
}
