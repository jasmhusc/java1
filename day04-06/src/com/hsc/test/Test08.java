package com.hsc.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test08 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            // 不能保证字母和数字出现次数
            //getTest();
            getTestpro();
        }
    }

    private static void getTest() {
        Random rand = new Random();
        String s = "";
        StringBuilder sb = new StringBuilder(s);
        char c;
        for (int i = 0; i < 4; i++) {
            double random = Math.random();
            if (random<0.5){
                c = getNum();
            }else if (random<0.75){
                c = getchar();
            }else{
                c = getchar();
            }
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
    private static void getTestpro() {
        String s = "";
        StringBuilder sb = new StringBuilder(s);
        ArrayList<Character> list = new ArrayList<>();
        list.add(getNum());
        list.add(getNum());
        list.add(getchar());
        list.add(getchar());
        Collections.shuffle(list);
        for (Character c : list) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
    private static char getNum(){
        return (char) (new Random().nextInt(10)+48);
    }
    private static char getchar(){
        if (Math.random()<0.5){
            return (char) (new Random().nextInt(26)+97);
        }else{
            return (char) (new Random().nextInt(26)+65);
        }
    }
}
