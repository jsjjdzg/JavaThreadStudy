package com.dzg.study.day20180330;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * Lock/Condition 演示
 * 
 * @author DZG
 * @since V1.0 2018年3月30日
 */
public class ConditionLockDemo {

	private Lock lock = new ReentrantLock(true);
	private Condition condition = lock.newCondition();

	public void await() {
		try {
			lock.lock();
			System.out.println("await time is：" + System.currentTimeMillis());
			condition.await();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void signal() {
		try {
			lock.lock();
			System.out.println("signal time is：" + System.currentTimeMillis());
			condition.signal();
		} finally {
			lock.unlock();
		}
	}
}
