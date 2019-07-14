package com.hsc.demo1;

import java.util.Scanner;

public class SwitchDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入星期的数字编号（1-7）：");
        int day = sc.nextInt();
       switch (day){
           case 1:
               System.out.println("星期一\n");
               break;
           case 2:
               System.out.println("星期二\n");
               break;
           case 3:
               System.out.println("星期三\n");
               break;
           case 4:
               System.out.println("星期四\n");
               break;
           case 5:
               System.out.println("星期五\n");
               break;
           case 6:
               System.out.println("星期六\n");
               break;
           case 7:
               System.out.println("星期日\n");
               break;
           default:
               System.out.println("输入有误！");
       }
    }
}
