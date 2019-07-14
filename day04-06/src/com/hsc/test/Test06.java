package com.hsc.test;

public class Test06 {
    public static void main(String[] args) {
        int[] arr = new int[11];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        for (int anInt : arr) {
            System.out.print(anInt+" ");
        }
        // 获取所有的人数
        int count=arr.length;
        // 获取每次数完后的活着的人数，并在循环完时记录下来，下次循环时使用
        int j=0;
        for (int i = 0;count>1; i++) {
            if (arr[i]!=0){
                if ((j+1)%3==0) {
                    arr[i]=0;
                    count--;
                }
                j++;
            }
            if (i==arr.length-1){
                i = -1;
            }
        }
        System.out.println("");
        for (int i : arr) {
            if (i!=0)
                System.out.println("活着的人是第"+i+"个");
        }
    }
}
