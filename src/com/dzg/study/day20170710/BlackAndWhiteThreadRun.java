package com.dzg.study.day20170710;

public class BlackAndWhiteThreadRun {

	public static void main(String[] args) {
		DBTools t = new DBTools();
		for (int i = 0; i < 5; i++) {
			BlackGoThread b = new BlackGoThread(t);
			b.start();
			WhiteGoThread w = new WhiteGoThread(t);
			w.start();
		}
	}
}
