package com.dzg.study.day20170613;

public class ThreadA extends Thread {

	private SynchronizedThisDemo demo;

	public ThreadA(SynchronizedThisDemo demo) {
		super();
		this.demo = demo;
	}

	@Override
	public void run() {
		super.run();
		demo.exeA();
	}

}
