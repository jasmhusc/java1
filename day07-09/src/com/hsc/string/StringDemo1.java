package com.hsc.string;

import java.util.Scanner;

public class StringDemo1 {
    public static void main(String[] args) {
        int c1=0;
        int c2=0;
        int c3=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("输入字符串：");
        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c>='0' && c<='9'){
                c1++;
            }else if (c>= 'a' && c<= 'z'){
                c2++;
            }else if (c>= 'A' && c<= 'Z'){
                c3++;
            }
        }

        System.out.println("数字："+c1+",小写字母："+c2+",大写字母："+c3);
    }
}
