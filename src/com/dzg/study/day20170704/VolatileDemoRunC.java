package com.dzg.study.day20170704;

public class VolatileDemoRunC {

	public static void main(String[] args) {
		VolatileDemoThreadC thread = new VolatileDemoThreadC();
		for (int i = 0; i < 100; i++) {
			new Thread(thread).start();
		}
	}
}
