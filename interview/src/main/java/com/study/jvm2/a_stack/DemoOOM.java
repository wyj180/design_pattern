package com.study.jvm2.a_stack;

import java.util.ArrayList;
import java.util.List;

public class DemoOOM {

    public static void main(String[] args) throws InterruptedException {
        List<byte[]> bytes = new ArrayList<>();
        while (true) {
            System.out.println("创建3M大对象");
            bytes.add(new byte[1024 * 1024 * 3]);
            Thread.sleep(500);
        }
    }
}
