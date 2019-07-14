package com.hsc.string;

import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串：");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

//        System.out.println(line+"反转后："+new StringBuilder(line).reverse().toString());
        System.out.println(line+"反转后："+reverse(line));
    }

    public static String reverse(String s){

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0 ; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
