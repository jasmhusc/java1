package com.hsc.test;

import java.util.Random;

public class Test04 {
    public static void main(String[] args) {
        getTest(20);
    }

    private static void getTest(int n) {
        for (int i = 0; i < n; i++) {
            int[] ints = new int[10];
            for (int j = 0; j < ints.length; j++) {
                ints[j] = j;
            }

            int v = 0;
            while (true) {
                int anInt = new Random().nextInt(10);
                if(ints[anInt]!=-1){
                    ints[anInt] = -1;
                    v++;
                }
                if (v==4)
                    break;
            }

            System.out.println("");
        }

    }
}
