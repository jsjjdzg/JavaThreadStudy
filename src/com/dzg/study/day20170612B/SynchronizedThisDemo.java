package com.dzg.study.day20170612B;

/**
 * 
 * 线程访问一个object中的synchronized代码块时，该object中其他synchronized代码块同时被阻塞(包括同步的方法).
 * 
 * @author DZG
 * @since V1.0 2017年6月12日
 */
public class SynchronizedThisDemo {

	public void exeA() {
		try {
			synchronized (this) {
				System.out.println("A begin");
				Thread.sleep(2000);
				System.out.println("A end");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void exeB() {
		synchronized (this) {
			System.out.println("B begin");
			System.out.println("B end");
		}
	}

	synchronized public void exeC() {
		System.out.println("B begin");
		System.out.println("B end");
	}
}
