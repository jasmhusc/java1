package com.hsc.demo1;

import java.util.Scanner;

public class SwitchDemo1 {
    public static void main(String[] args) {
        // 输入月份，获得季节
        System.out.println("请输入一个月份：");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();

        switch (month){
            case 12:
            case 1:
            case 2:
                System.out.println("春季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("夏季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("秋季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("冬季");
                break;
            default:
                System.out.println("输入月份有误！");
        }
    }
}
