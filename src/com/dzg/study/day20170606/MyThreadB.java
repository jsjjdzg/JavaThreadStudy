package com.dzg.study.day20170606;

public class MyThreadB extends Thread {

	@Override
	public void run() {
		while (true) {
			System.out.println(System.currentTimeMillis());
			if (this.isInterrupted()) {
				System.out.println("停止线程");
				return;
			}
		}
	}
}
