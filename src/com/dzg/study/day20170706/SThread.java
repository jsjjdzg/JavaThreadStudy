package com.dzg.study.day20170706;

public class SThread extends Thread{

	private S s;

	public SThread(S s) {
		super();
		this.s = s;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
				s.getValue();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
