package com.hsc.demo1;
/*
* char 类型变量单独输出表示一个字符
*      如果参与计算则自动提升为 int类型
* */
public class SumDemo {
    public static void main(String[] args) {
        //Demo();
        char c = 'a';
        System.out.println(c); //  a
        int i = c + 12;
        System.out.println(i);  //  109

        char ch = 'A'+3;
        System.out.println(ch);  // D
    }

    private static void Demo() {
        int i =20;
//        int j = i++;   20
        int j = ++i;   //21
        System.out.println(j);
    }
}
