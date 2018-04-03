package com.dzg.study.day20180403;

/**
 * 
 * 线程组演示
 * 
 * @author DZG
 * @since V1.0 2018年4月3日
 */
public class ThreadGroupDemo {

	public static void main(String[] args) {
		Thread ta = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (!Thread.currentThread().isInterrupted()) {
						System.out.println(Thread.currentThread().getName() + "正在运行");
						Thread.sleep(3000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Thread tb = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (!Thread.currentThread().isInterrupted()) {
						System.out.println(Thread.currentThread().getName() + "正在运行");
						Thread.sleep(3000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		ThreadGroup tg = new ThreadGroup("测试线程组");
		Thread ra = new Thread(tg, ta);
		Thread rb = new Thread(tg, tb);

		ra.start();
		rb.start();

		System.out.println(tg.activeCount() + " " + tg.getName());
	}
}
