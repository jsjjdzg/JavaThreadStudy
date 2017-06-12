package com.dzg.study.day20170612B;

public class ThreadB extends Thread {

	private SynchronizedThisDemo demo;

	public ThreadB(SynchronizedThisDemo demo) {
		super();
		this.demo = demo;
	}

	@Override
	public void run() {
		super.run();
		//demo.exeB();
		demo.exeC();
	}

}
