package com.study.aqs;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class A_LookAQSUse {

    public static void main(String[] args) {



        //Semaphore semaphore = new Semaphore(10);

        ReentrantLock reentrantLock = new ReentrantLock();

        //new CountDownLatch();

        new Semaphore(1);
    }
}
