package com.dzg.study.day20170710;

public class WhiteGoThread extends Thread {

	private DBTools t;

	public WhiteGoThread(DBTools t) {
		super();
		this.t = t;
	}

	public void run() {
		t.whiteGo();
	}
}
