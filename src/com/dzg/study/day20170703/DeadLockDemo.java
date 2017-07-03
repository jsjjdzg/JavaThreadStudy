package com.dzg.study.day20170703;

/**
 * 
 * 多线程死锁：不同的线程都在等待不可能释放的锁
 * 只要互相等待对方释放锁就有可能出现死锁
 * 
 * @author DZG
 * @since V1.0 2017年7月3日
 */
public class DeadLockDemo implements Runnable {

	public String username;
	public Object obj1 = new Object();
	public Object obj2 = new Object();

	public void setFlag(String username) {
		this.username = username;
	}

	@Override
	public void run() {
		if (username.equals("a")) {
			synchronized (obj1) {
				try {
					System.out.println("begin A username是" + username);
					Thread.sleep(3000);
					System.out.println("end A username是" + username);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj2) {
					System.out.println("lockA -> lockB");
				}
			}
		}
		if (username.equals("b")) {
			synchronized (obj2) {
				try {
					System.out.println("begin B username是" + username);
					Thread.sleep(3000);
					System.out.println("end B username是" + username);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (obj1) {
					System.out.println("lockB -> lockA");
				}
			}
		}
	}

}
