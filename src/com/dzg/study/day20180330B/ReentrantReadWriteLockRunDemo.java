package com.dzg.study.day20180330B;

public class ReentrantReadWriteLockRunDemo {

	public static void main(String[] args) {
		ReentrantReadWriteLockDemo lockDemo = new ReentrantReadWriteLockDemo();

		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				lockDemo.test();
			}
		});

		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				lockDemo.test();
			}
		});

		a.start();
		b.start();
	}
}
