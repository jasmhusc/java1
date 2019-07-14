package com.hsc.test;

import java.util.Arrays;
import java.util.Random;

public class Test02 {
    public static void main(String[] args) {
        getTest(20);
    }

    private static void getTest(int n) {
        for (int v = 0; v < n; v++) {
            int[] arr = {-1,-1,-1,-1,-1,-1};
            int k = 0;
            int r;
            MAIN_LOOP:
            while (k<6){
                r = new Random().nextInt(10);
                for (int i = 0; i <= k; i++) {
                    if (arr[i] == r)
                        continue MAIN_LOOP;
                }
                arr[k] = r;
                k++;
            }
            /*for (int i : arr) {
                System.out.print(i);
            }*/
            System.out.println(Arrays.toString(arr));
        }
    }
}
