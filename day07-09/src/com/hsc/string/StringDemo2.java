package com.hsc.string;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDemo2 {
    public static void main(String[] args) {
        String regx = "[1-9][0-9]{16}[0-9X]";
        Pattern p = Pattern.compile(regx);
        String s = new Scanner(System.in).nextLine();
        Matcher m = p.matcher(s);
        if(m.matches())
            System.out.println("666");
        else
            System.out.println("111");
    }
}
