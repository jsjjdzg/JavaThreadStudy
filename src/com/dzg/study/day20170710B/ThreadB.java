package com.dzg.study.day20170710B;

/**
 * 
 * 线程B 有同步方法等待调用
 * 
 * @author DZG
 * @since V1.0 2017年7月10日
 */
public class ThreadB extends Thread {

	public void run() {
		try {
			System.out.println("线程B run 方法 begin");
			Thread.sleep(5000);
			System.out.println("线程B run 方法 end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	synchronized public void execute() {
		System.out.println("线程B execute 方法被调用");
	}
}
