package com.dzg.study.day20170703;

/**
 * 
 * synchronized 用于 static方法是对该Class类进行锁，用于非static方法是对对象加锁
 * 对象锁和Class类锁，Class类锁对类的所有对象实例起作用
 * 同步代码块synchronized(class)和 synchronized static方法的作用是一样的
 * 
 * @author DZG
 * @since V1.0 2017年7月3日
 */
public class Service {

	public synchronized static void printA() {
		try {
			System.out.println(Thread.currentThread().getName() + "进入线程A");
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + "离开线程A");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized static void printB() {
		System.out.println(Thread.currentThread().getName() + "进入线程B");
		System.out.println(Thread.currentThread().getName() + "离开线程B");
	}

	/**
	 * 都是锁Class，C会比B先执行，C是已经进入方法内被锁住，但是B要等C的锁释放才能进行
	 * 
	 * @since 2017年7月3日
	 */
	public void printC() {
		synchronized (Service.class) {
			System.out.println(Thread.currentThread().getName() + "进入线程C");
			System.out.println(Thread.currentThread().getName() + "离开线程C");
		}
	}
}
