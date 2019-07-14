package javabase_Test;

import java.util.Scanner;

public class Test_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数n:");
        int n = sc.nextInt();
        int m = 0;
        for (int i = 1; i <= n; i++) {
            if (i%3==0)
                m+=i;
        }
        System.out.println("1-"+n+" 之间的 3 的倍数累加和为："+m);
    }
}
