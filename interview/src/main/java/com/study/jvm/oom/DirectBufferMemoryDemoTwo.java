package com.study.jvm.oom;

import sun.misc.VM;

import java.nio.ByteBuffer;

public class DirectBufferMemoryDemoTwo {

    public static void main(String[] args) throws Exception {
        System.out.println("maxDirectMemory: "
                + VM.maxDirectMemory() / (double) 1024 / 1024 + "MB");
        Thread.sleep(100);
        // -XX:MaxDirectMemorySize=5m
        // 使用6m的直接内存，故意破坏
        ByteBuffer bb = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}