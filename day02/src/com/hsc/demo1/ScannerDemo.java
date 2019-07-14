package com.hsc.demo1;

import java.util.HashSet;
import java.util.Scanner;

public class ScannerDemo {
    public static void main (String[] args){
        HashSet<Double> monks = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入第一个和尚的身高（cm）:");
        monks.add(sc.nextDouble());
        System.out.println("请输入第二个和尚的身高（cm）:");
        monks.add(sc.nextDouble());
        System.out.println("请输入第三个和尚的身高（cm）:");
        monks.add(sc.nextDouble());

        System.out.println("三个和尚中身高最高的是："+monks.toArray()[2]+"cm");
    }
}
