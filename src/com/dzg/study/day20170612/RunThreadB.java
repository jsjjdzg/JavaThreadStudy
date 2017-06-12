package com.dzg.study.day20170612;

public class RunThreadB extends Thread {

	private HasSalfNumber hn;

	public RunThreadB(HasSalfNumber hn) {
		super();
		this.hn = hn;
	}

	@Override
	public void run() {
		super.run();
		//hn.addNum("b");
		//hn.addNumC();
		hn.testExceptionThreadStop();
	}

}