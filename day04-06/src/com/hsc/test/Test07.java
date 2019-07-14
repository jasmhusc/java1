package com.hsc.test;

public class Test07 {
    public static void main(String[] args) {
        int i=0,count = 0;
        while (i<100){
            if (i%2==0)
                count++;
            i++;
        }
        System.out.println(count);
    }
}
