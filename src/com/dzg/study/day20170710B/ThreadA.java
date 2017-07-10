package com.dzg.study.day20170710B;

/**
 * 
 * join(long) 会释放锁(底层有wait()实现)
 * sleep(long) 不会释放素
 * 
 * @author DZG
 * @since V1.0 2017年7月10日
 */
public class ThreadA extends Thread {

	private ThreadB b;

	public ThreadA(ThreadB b) {
		super();
		this.b = b;
	}

	public void run() {
		try {
			synchronized (b) {
				b.start();
				b.join(5000);
				//Thread.sleep(6000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
