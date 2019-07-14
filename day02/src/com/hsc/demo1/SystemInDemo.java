package com.hsc.demo1;

import java.io.InputStreamReader;
import java.io.PrintStream;

public class SystemInDemo {
    public static void main(String[] args) throws Exception {

        InputStreamReader in = new InputStreamReader(System.in);
        PrintStream out = System.out;
        int i = in.read();
        out.println(i);
    }
}
