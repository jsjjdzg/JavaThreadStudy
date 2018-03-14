package com.dzg.study.day20170703;

public class RunDeadLockDemo2018 {

	public static void main(String[] args) throws InterruptedException {
		DeadLockThreadDemo2018 dlt = new DeadLockThreadDemo2018();
		dlt.setName("a");
		Thread a = new Thread(dlt);
		a.start();

		Thread.sleep(100);
		
		dlt.setName("b");
		Thread b = new Thread(dlt);
		b.start();
	}
}
