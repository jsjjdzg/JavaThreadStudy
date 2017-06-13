package com.dzg.study.day20170613;

public class RunThread {

	public static void main(String[] args) {
		SynchronizedThisDemo demo = new SynchronizedThisDemo();
		ThreadA a = new ThreadA(demo);
		a.start();
		ThreadB b = new ThreadB(demo);
		b.start();
	}
}
