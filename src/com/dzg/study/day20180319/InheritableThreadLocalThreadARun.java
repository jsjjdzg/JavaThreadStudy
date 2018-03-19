package com.dzg.study.day20180319;

public class InheritableThreadLocalThreadARun {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			System.out.println(ThreadLocalTool.t2.get());
			Thread.sleep(200);
		}
		
		Thread.sleep(2000);
		
		InheritableThreadLocalThreadA a = new InheritableThreadLocalThreadA();
		a.start();
	}
}
