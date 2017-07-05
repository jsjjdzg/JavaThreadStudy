package com.dzg.study.day20170705;

/**
 * 
 * notify()/notifyAll()
 * 1. 作用通知该对象锁的等待线程，如有多个线程等待，由线程规划器随机挑选一个wait的线程。
 * 2. 也 只能在同步方法/同步块调用 notify()。
 * 3. 要等到执行notify()将程序执行完，即退出synchronized代码块后，才会释放锁，wait的线程才会等到锁。
 * 
 * @author DZG
 * @since V1.0 2017年7月5日
 */
public class NotifyThreadA extends Thread{

	private Object lock;
	
	public NotifyThreadA(Object lock){
		super();
		this.lock = lock;
	}
	
	public void run(){
		try {
			synchronized(lock){
				System.out.println(Thread.currentThread().getName() + "开始通知");
				Thread.sleep(5000);
				lock.notify(); // 随机挑选一个wait线程
				//lock.notifyAll(); // 所有该lock的wait线程都收到通知
				System.out.println(Thread.currentThread().getName() + "结束通知");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
