package com.dzg.study.day20170706;

public class PThread extends Thread {

	private P p;

	public PThread(P p) {
		super();
		this.p = p;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				p.setValue();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
