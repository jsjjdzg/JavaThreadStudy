package com.dzg.study.day20170705;

public class RunWaitAndNotifyDemo {

	public static void main(String[] args) {
		Object lock = new Object();

		WaitThreadDemo2018 thread1 = new WaitThreadDemo2018(lock);
		thread1.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		NotifyThreadDemo2018 thread2 = new NotifyThreadDemo2018(lock);
		thread2.start();
	}
}
