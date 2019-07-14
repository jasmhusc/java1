package com.hsc.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test10 {
    public static void main(String[] args) {
        judge(6);
    }
/*
* ^100$|^(\d[1-9]\d)(\.\d+)*$
* ^100$|^(\d[1-9]\d)$
* */
    private static void judge(int a) {
        int[] arr = new int[a];
        int i = 0;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入第"+(i+1)+"个评委打分数：");
            String s = sc.nextLine();
            String regex = "[0-9-][0-9]{0,2}";
//            String regex = "/^100$|^(\\d[1-9]\\d)$/";
            Matcher matcher = Pattern.compile(regex).matcher(s);
            if ((matcher.find()) && (i < arr.length)){
                int an= Integer.parseInt(matcher.group());
                if (an<0 || an>100){
                    System.out.print("您输入的分数有误,");
                    continue;
                }
                arr[i] = an;
                i++;
                if (i==arr.length) {
                    break;
                }
            }else{
                System.out.println("您输入的分数有误，请重新输入：");
            }
        }
        // 遍历打印输出一波
        print(arr);
        // 调用求最值函数
        int max = sort(arr)[arr.length-1];
        int min = sort(arr)[0];
        // 执行打分
        int avr = (sum(arr) - max - min) / (arr.length-2);
        System.out.println("去除一个最高分："+max+", 去除一个最低分："+min);
        System.out.println("最终评委打分为："+avr);
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum+=i;
        }
        return sum;
    }

    private static void print(int[] arr) {
        System.out.println("评委打分依次为：");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println("");
    }

    private static int[] sort(int[] arr){
        int len = arr.length-1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arr[i]>arr[i+1]){
                    int temp = arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        return arr;
    }
}
