package com.study.juc.a_jiagou;

public class TestString2 {

    public static void main(String[] args) {
        String a = "wukong2";
        final String b = "wukong";
        String d = "wukong";
        String c = b + 2;
        String e = d + 2;

        System.out.println(a == c); // true
        System.out.println(a == e); // false
    }
}
