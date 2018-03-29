package com.dzg.study.day20180319B;

public class ReentranLockRunDemo {

	public static void main(String[] args) {
		ReentranLockDemo d = new ReentranLockDemo();
		new Thread(new Runnable() {
			@Override
			public void run() {
				d.test();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				d.test();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				d.test();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				d.test();
			}
		}).start();
	}
}
