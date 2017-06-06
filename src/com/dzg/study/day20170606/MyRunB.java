package com.dzg.study.day20170606;

/**
 * 
 * 测试 interrupt() 和 return 来停止线程 不使用 stop() 强制停止
 * 
 * @author DZG
 * @since V1.0 2017年6月6日
 */
public class MyRunB {

	public static void main(String[] args) throws InterruptedException {
		MyThreadB m = new MyThreadB();
		m.start();
		Thread.sleep(10);
		m.interrupt();
	}
}
