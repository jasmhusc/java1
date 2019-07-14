package com.hsc.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Test05 {
    public static void main(String[] args) {
        getTest(20);

    }

    private static void getTest(int n) {
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0;set.size()<6; j++) {
                int index = new Random().nextInt(10);
                set.add(index);
            }

            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(set);
            Collections.shuffle(list);

            for (Integer j : list) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }
}
