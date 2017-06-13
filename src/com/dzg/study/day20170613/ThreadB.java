package com.dzg.study.day20170613;

public class ThreadB extends Thread {

	private SynchronizedThisDemo demo;

	public ThreadB(SynchronizedThisDemo demo) {
		super();
		this.demo = demo;
	}

	@Override
	public void run() {
		super.run();
		demo.exeA();
		//demo.exeB();
		//demo.exeC();
	}

}
