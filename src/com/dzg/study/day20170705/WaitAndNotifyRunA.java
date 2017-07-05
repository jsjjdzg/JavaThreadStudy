package com.dzg.study.day20170705;

public class WaitAndNotifyRunA {

	public static void main(String[] args) {
		Object lock = new Object();
		WaitThreadA a1 = new WaitThreadA(lock);
		a1.setName("A");
		a1.start();
		WaitThreadA a2 = new WaitThreadA(lock);
		a2.setName("B");
		a2.start();
		NotifyThreadA b = new NotifyThreadA(lock);
		b.start();
	}
	
	// 没有取得对象锁，wait()会报 IllegalMonitorStateException 异常
	public static void mainB(String[] args) {
		try {
			String a = "a";
			a.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
