package com.study.jvm.oom;

import java.util.Random;

public class JavaHeapSpaceDemo {

    public static void main(String[] args) {
        String str = "atguigu";
        while (true) {
            str += str + new Random().nextInt(11111111) + new Random().nextInt(2222222);
            str.intern();
        }
    }
}