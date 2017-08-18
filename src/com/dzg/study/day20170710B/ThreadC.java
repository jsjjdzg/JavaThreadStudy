package com.dzg.study.day20170710B;

public class ThreadC extends Thread {

	private ThreadB b;

	public ThreadC(ThreadB b) {
		super();
		this.b = b;
	}

	public void run() {
		b.execute();
	}
}
