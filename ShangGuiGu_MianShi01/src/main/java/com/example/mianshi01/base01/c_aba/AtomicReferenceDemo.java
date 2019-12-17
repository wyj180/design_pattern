package com.example.mianshi01.base01.c_aba;

import java.util.concurrent.atomic.AtomicReference;

// 原子引用Demo
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        User z3 = new User("z3", 22);
        User li4 = new User("li4", 25);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3, li4) + "\t" + z3.toString());
        System.out.println(atomicReference.compareAndSet(z3, li4) + "\t" + z3.toString());

    }
}
