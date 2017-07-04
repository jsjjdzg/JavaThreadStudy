package com.dzg.study.day20170704;

public class VolatileDemoRunB {

	public static void main(String[] args) {
		VolatileDemoThreadB[] threads = new VolatileDemoThreadB[100];
		for (int i = 0; i < 100; i++) {
			threads[i] = new VolatileDemoThreadB();
		}
		for (int i = 0; i < 100; i++) {
			threads[i].start();
		}
	}
}
