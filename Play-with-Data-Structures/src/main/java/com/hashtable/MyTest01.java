package com.hashtable;

public class MyTest01 {

    public static void main(String[] args) {
        MyHashTable<String, String> map = new MyHashTable<>();
        map.add("s1", "v1");
        map.add("s2", "v2");
        map.add("s3", "v3");

        System.out.println(map.getSize());
        System.out.println(map.get("s1"));

    }
}
