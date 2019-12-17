package com.study.jvm;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {

	public static void main(String[] args) {
		Object o1 = new Object();
		WeakReference<Object> softReference = new WeakReference<>(o1);
		System.out.println(o1);
		System.out.println(softReference.get()); // 获取弱引用中的对象，用get()方法

		o1 = null;
		System.gc();

		System.out.println(o1);
		System.out.println(softReference.get());
	}
}
