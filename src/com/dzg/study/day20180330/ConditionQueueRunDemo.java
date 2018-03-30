package com.dzg.study.day20180330;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 
 * Condition顺序执行
 * 
 * @author DZG
 * @since V1.0 2018年3月30日
 */
public class ConditionQueueRunDemo {

	volatile private static int netWho = 1;
	private static ReentrantLock lock = new ReentrantLock();
	private final static Condition c1 = lock.newCondition();
	private final static Condition c2 = lock.newCondition();
	private final static Condition c3 = lock.newCondition();

	public static void main(String[] args) {
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lock();
					if (netWho != 1) {
						c1.await();
					}
					IntStream.range(0, 3).forEach(idx -> {
						System.out.println("ThreadA run " + (idx + 1));
					});
					netWho = 2;
					c2.signalAll();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		});
		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lock();
					if (netWho != 2) {
						c2.await();
					}
					IntStream.range(0, 3).forEach(idx -> {
						System.out.println("ThreadB run " + (idx + 1));
					});
					netWho = 3;
					c3.signalAll();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		});
		Thread c = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lock();
					if (netWho != 3) {
						c3.await();
					}
					IntStream.range(0, 3).forEach(idx -> {
						System.out.println("ThreadC run " + (idx + 1));
					});
					netWho = 1;
					c1.signalAll();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		});

		Thread[] aa = new Thread[5];
		Thread[] bb = new Thread[5];
		Thread[] cc = new Thread[5];
		IntStream.range(0, 5).forEach(idx -> {
			aa[idx] = new Thread(a);
			bb[idx] = new Thread(b);
			cc[idx] = new Thread(c);
			aa[idx].start();
			bb[idx].start();
			cc[idx].start();
		});
	}
}
