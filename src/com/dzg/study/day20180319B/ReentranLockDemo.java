package com.dzg.study.day20180319B;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentranLockDemo {
	private Lock lock = new ReentrantLock();

	public void test() {
		lock.lock();
		for (int i = 0; i < 10; i++) {
			System.out.println("ThreadName:" + Thread.currentThread().getName() + "  " + (i + 1));
		}
		lock.unlock();
	}
}
