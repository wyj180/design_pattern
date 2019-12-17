package com.study.jvm;

public class Test01 {

    public static void main(String[] args) {
        System.out.println("start....");
        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end....");
    }

}
