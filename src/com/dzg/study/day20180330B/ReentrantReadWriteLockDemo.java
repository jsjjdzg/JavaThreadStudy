package com.dzg.study.day20180330B;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * 读写锁Demo
 * 
 * @author DZG
 * @since V1.0 2018年3月30日
 */
public class ReentrantReadWriteLockDemo {

	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public void test() {
		try {
			lock.readLock().lock();
			// lock.writeLock().lock();
			System.out.println(Thread.currentThread().getName() + " XX " + System.currentTimeMillis());
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
			// lock.writeLock().unlock();
		}
	}
}
