package com.dzg.study.day20170703;

/**
 * 
 * 死锁的Demo
 * 
 * @author DZG
 * @since V1.0 2018年3月12日
 */
public class DeadLockThreadDemo2018 implements Runnable {

	public String name;
	public Object lock1 = new Object();
	public Object lock2 = new Object();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		if ("a".equals(name)) {
			synchronized (lock1) {
				try {
					System.out.println("name is a lock1");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("name is a lock1 -> lock2");
				}
			}
		}

		if ("b".equals(name)) {
			synchronized (lock2) {
				try {
					System.out.println("name is a lock2");
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println("name is a lock2 -> lock1");
				}
			}
		}
	}

}
