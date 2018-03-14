package com.dzg.study.day20170705;

public class WaitThreadDemo2018 extends Thread {

	private Object lock;

	public WaitThreadDemo2018(Object lock) {
		super();
		this.lock = lock;
	}

	public void run() {
		System.out.println("开始 W");
		try {
			synchronized (lock) {
				for (int i = 0; i < 10; i++) {
					ListDemo.addList();
					System.out.println("添加到第" + i + "个");
					if (ListDemo.getListSize() == 5) {
						lock.notify();
						System.out.println("已发出通知");
					}
					Thread.sleep(1000);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
