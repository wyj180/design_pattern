package com.study.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceDemo {

	public static void main(String[] args) throws InterruptedException {
		Object o1 = new Object();
		ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
		PhantomReference<Object> phantomReference = new PhantomReference<>(o1, referenceQueue);
		
		System.out.println("weakReference:" + phantomReference);
		System.out.println("           o1:" + o1);
		System.out.println();
		
		System.out.println(phantomReference.get());
		System.out.println(referenceQueue.poll());

		System.out.println("-----------gc()后---------------");

		o1 = null;
		System.gc();
		Thread.sleep(500);

		System.out.println(o1);
		System.out.println("gc()之后：" + phantomReference.get());
		System.out.println("gc()之后：" + referenceQueue.poll());
	}
}
