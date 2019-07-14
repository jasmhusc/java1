package com.hsc.test;

import java.util.Scanner;

public class Test09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个整数（1~3）：");
        int a = sc.nextInt();
        switch (a){
            case 1:
                System.out.println("冠军");
                break;
            case 2:
                System.out.println("亚军");
                break;
            case 3:
                System.out.println("季军");
                break;
            default:
                System.out.println("狗屁");
        }
    }
}
