package com.study.jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class ReferenceQueueDemo {

	public static void main(String[] args) throws InterruptedException {
		Object o1 = new Object();
		ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
		WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);
		
		System.out.println("weakReference:" + weakReference);
		System.out.println("           o1:" + o1);
		System.out.println();
		
		System.out.println(weakReference.get());
		System.out.println(referenceQueue.poll());

		System.out.println();

		o1 = null;
		System.gc();
		Thread.sleep(500);
		System.out.println("-------------------------------");

		System.out.println(o1);
		System.out.println("gc()之后：" + weakReference.get());
		System.out.println("gc()之后：" + referenceQueue.poll());
	}
}
