package com.dzg.study.day20170705;

public class NotifyThreadDemo2018 extends Thread {

	private Object lock;

	public NotifyThreadDemo2018(Object lock) {
		super();
		this.lock = lock;
	}

	public void run() {
		System.out.println("开始 N");
		synchronized (lock) {
			try {
				lock.wait();
				System.out.println("list目前有5个");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
