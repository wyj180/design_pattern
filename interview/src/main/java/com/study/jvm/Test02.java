package com.study.jvm;

public class Test02 {

    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();

        System.out.println("Total Memory(-Xms) = " + (totalMemory/(1024 * 1024)));
        System.out.println("Max Memory(-Xmx) = " + (maxMemory/(1024 * 1024)));
    }

}
