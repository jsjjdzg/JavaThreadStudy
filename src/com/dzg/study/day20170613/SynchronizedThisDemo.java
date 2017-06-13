package com.dzg.study.day20170613;

/**
 * 
 * 线程访问一个object中的synchronized代码块时，该object中其他synchronized代码块同时被阻塞(包括同步的方法).
 * 
 * 若是每次都是synchronized(this)对象，其他synchronized都被阻塞会大大降低效率，
 *  一般采用synchronized(非this)，不与其他锁this的方法争抢this锁，提高运行效率.
 * 
 * @author DZG
 * @since V1.0 2017年6月12日
 */
public class SynchronizedThisDemo {

	public void exeA() {
		String b = "a";
		// String a = new String(); a为不同锁，b为相同锁
		try {
			// synchronized(非this)，其他阻塞synchronized方法/块继续运行
			synchronized (b) {
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
		System.out.println("C begin");
		System.out.println("C end");
	}
}
