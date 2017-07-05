package com.dzg.study.day20170705;

/**
 * 
 * wait() 
 * 1. 作用是使当前执行代码的线程就行等待，直到接收到通知/中断为止。 
 * 2. 调用wait()方法时必须获得对象级锁，也就是 只能在同步方法/同步块调用 wait()。
 * 
 * wait(long x) 
 * 等待某一定时间是否有线程对锁进行唤醒，超出时间自动唤醒
 * 
 * @author DZG
 * @since V1.0 2017年7月5日
 */
public class WaitThreadA extends Thread{

	private Object lock;
	
	public WaitThreadA(Object lock){
		super();
		this.lock = lock;
	}
	
	public void run(){
		try {
			synchronized(lock){
				System.out.println("开始等待，线程名称 ：" + Thread.currentThread().getName());
				lock.wait(2000);
				System.out.println("结束等待，线程名称 ：" + Thread.currentThread().getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
