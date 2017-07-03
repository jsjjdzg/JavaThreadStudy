package com.dzg.study.day20170703;

public class DeadLockRun {

	public static void main(String[] args) {		
		try {
			DeadLockDemo d = new DeadLockDemo();
			d.setFlag("a");
			Thread t1 = new Thread(d);
			t1.start();
			Thread.sleep(100);
			d.setFlag("b");
			Thread t2 = new Thread(d);
			t2.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
