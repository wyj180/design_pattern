package com.study.juc.a_jiagou;

public class TestString3 {

    public static void main(String[] args) {
        String a = "wukong2";
        final String b = getDashixiong();
        String c = b + 2;

        System.out.println(a == c); // false
        System.out.println(a.equals(c)); // true
    }

    private static String getDashixiong(){
        return "wukong";
    }
}
