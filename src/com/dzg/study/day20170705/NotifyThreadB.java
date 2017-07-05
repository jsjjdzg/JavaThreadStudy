package com.dzg.study.day20170705;

/**
 * 
 * wait()会立即释放锁，notify()需要等到synchronized方法/代码块执行完释放锁
 * 
 * @author DZG
 * @since V1.0 2017年7月5日
 */
public class NotifyThreadB extends Thread{

	private Object lock;
	
	public NotifyThreadB(Object lock){
		super();
		this.lock = lock;
	}
	
	public void run(){
		try {
			synchronized(lock){
				System.out.println(Thread.currentThread().getName() + "开始通知");
				lock.notify();
				Thread.sleep(5000);
				System.out.println(Thread.currentThread().getName() + "结束通知");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
