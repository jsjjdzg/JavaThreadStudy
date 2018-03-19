package com.dzg.study.day20180319;

public class ThreadLocalRunDemo {
	public static void main(String[] args) throws InterruptedException {
		ThreadLocalThreadA a = new ThreadLocalThreadA();
		a.start();
		ThreadLocalThreadB b = new ThreadLocalThreadB();
		b.start();
		for (int i = 0; i < 10; i++) {	
			ThreadLocalTool.t1.set(i + 1);
			System.out.println("ThreadMain:" + ThreadLocalTool.t1.get());
			Thread.sleep(200);
		}
	}
}
