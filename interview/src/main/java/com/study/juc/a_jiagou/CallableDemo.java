package com.study.juc.a_jiagou;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

// Callable有返回值，且可以抛出异常
class MyThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " come in Callable");
		TimeUnit.SECONDS.sleep(5);
		return 1024;
	}
}

public class CallableDemo {

	public static void main(String[] args) {
		FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());
		FutureTask<Integer> futureTask2 = new FutureTask<Integer>(new MyThread());

		new Thread(futureTask, "AA").start();
		new Thread(futureTask2, "BB").start();
	}

	/*public static void main(String[] args) throws Exception {

		// FutureTask(Callable<V> callable)
		FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
		// FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread()); // 情景二：多个FutureTask，多个线程，会计算多次

		new Thread(futureTask, "AA线程").start();
		// new Thread(futureTask2, "BB线程").start(); // 情景一：一个FutureTask，多个线程，只会计算一次
		// int result02 = futureTask.get(); // 阻塞获取结果; 建议放在最后

		// futureTask.get(1, TimeUnit.SECONDS); // 等待指定时间，获取不到结果，就不阻塞了
		System.out.println(Thread.currentThread().getName()+"------------");

		int result01 = 100;

		 while(!futureTask.isDone()) { // 还没计算完的情况
			 System.out.println("判断是否获取成功...");
		 }

		int result02 = futureTask.get(); // 阻塞获取结果; 建议放在最后
		System.out.println("result:" + (result01 + result02));
	}
*/
}