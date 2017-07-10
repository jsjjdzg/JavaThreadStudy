package com.dzg.study.day20170710;

public class BlackGoThread extends Thread {

	private DBTools t;

	public BlackGoThread(DBTools t) {
		super();
		this.t = t;
	}

	public void run() {
		t.blackGo();
	}
}
