package com.hsc.test;

public class Test03 {
    public static void main(String[] args) {
        getTest(20);
    }

    private static void getTest(int n) {
        for (int k = 0; k < n; k++) {
                int[] ints = new int[10];
            for (int a = 0; a < ints.length; a++) {
                ints[a] = a;
            }
                for (int i = 0; i < ints.length; i++) {
                    for (int j = 0; j < ints.length; j++) {
                        if (Math.random()<0.5){
                            int temp = ints[i];
                            ints[i] = ints[j];
                            ints[j] = temp;
                        }
                    }
                }
                for (int i = 0; i < 6; i++) {
                    System.out.print(ints[i]);
                }
            System.out.println("");
        }

    }
}
