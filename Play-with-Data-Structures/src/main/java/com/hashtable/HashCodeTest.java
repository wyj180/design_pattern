package com.hashtable;

import org.junit.Test;

public class HashCodeTest {

    @Test
    public void test01() {
        int a = 4211;
        System.out.println(((Integer) a).hashCode());

        int b = -4211;
        System.out.println(((Integer) b).hashCode());
    }

    @Test
    public void test02() {
        double c = 3.14;
        System.out.println(((Double) c).hashCode());
    }

    @Test
    public void test03() {
        String c = "imooc";
        System.out.println(c.hashCode());
    }

    @Test
    public void test04() {
        Student student = new Student(3, 2, "bobo", "bobo");
        Student student2 = new Student(3, 2, "BOBO", "BOBO");

        System.out.println(student.hashCode());
        System.out.println(student2.hashCode());
    }


}
