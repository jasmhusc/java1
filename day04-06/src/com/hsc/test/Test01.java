package com.hsc.test;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        System.out.println("请输入两个数：");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        System.out.println(sum(i, j));
    }
    private static int sum(int i, int j){
        return i+j;
    }
}
