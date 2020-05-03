package com.study.jvm;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

	public static void main(String[] args) {
		 myHashmap();
		//myWeakHashmap();
	}

	private static void myWeakHashmap() {
		WeakHashMap<Integer, String> map = new WeakHashMap<>();
		Integer key = new Integer(1);
		String value = "hashMap的值";

		map.put(key, value);
		System.out.println(map);

		key = null;
		System.out.println("key = null  之后：" + map);

		System.gc();
		System.out.println("System.gc() 之后：" + map);
	}


	private static void myHashmap() {
		HashMap<Integer, String> map = new HashMap<>();
		Integer key = new Integer(1);
		String value = "hashMap的值";

		map.put(key, value);
		System.out.println(map);
		
		key = null;
		System.out.println("key = null 之后：" + map);

		System.gc();
		System.out.println("System.gc() 之后：" + map);
	}
}
