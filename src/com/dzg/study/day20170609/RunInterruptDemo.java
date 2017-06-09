package com.dzg.study.day20170609;

public class RunInterruptDemo {

	/**
	 * 建议使用 ： interrupt() 和 return 结合停止线程
	 */
	public static void main(String[] args) throws InterruptedException {
		InterruptThreadDemo thread = new InterruptThreadDemo();
		thread.start();
		Thread.sleep(500);
		thread.interrupt();
		System.out.println("main end");
	}
	
	/**
	 * 使用异常停止线程
	 */
/*	public static void main(String[] args) throws InterruptedException {
		InterruptThreadDemo thread = new InterruptThreadDemo();
		thread.start();
		Thread.sleep(100);
		thread.interrupt();
		System.out.println("main end");
	}*/
	
	/**
	 * 在睡眠中sleep()中停止线程
	 */
/*	public static void main(String[] args) throws InterruptedException {
		InterruptThreadDemo thread = new InterruptThreadDemo();
		thread.start();
		thread.interrupt();
		System.out.println("main end");
	}*/
	
	/**
	 * stop()暴力停止线程
	 */
/*	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		InterruptThreadDemo thread = new InterruptThreadDemo();
		thread.start();
		Thread.sleep(10000);
		thread.stop();
		System.out.println("main end");
	}*/
/*	public static void main(String[] args) throws InterruptedException {
		InterruptThreadDemo thread = new InterruptThreadDemo();
		thread.start();
		System.out.println("main end");
	}*/
}
