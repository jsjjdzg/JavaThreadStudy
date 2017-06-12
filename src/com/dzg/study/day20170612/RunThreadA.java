package com.dzg.study.day20170612;

public class RunThreadA extends Thread {

	private HasSalfNumber hn;

	public RunThreadA(HasSalfNumber hn) {
		super();
		this.hn = hn;
	}

	@Override
	public void run() {
		super.run();
		//hn.addNum("a");
		//hn.addNumB();
		hn.testExceptionThreadStop();
	}

}
