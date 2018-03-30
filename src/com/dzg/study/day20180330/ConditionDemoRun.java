package com.dzg.study.day20180330;

/**
 * 
 * Lock/Condition 运行演示
 * 
 * @author DZG
 * @since V1.0 2018年3月30日
 */
public class ConditionDemoRun {
	public static void main(String[] args) throws InterruptedException {

		ConditionLockDemo demo = new ConditionLockDemo();

		new Thread(new Runnable() {

			@Override
			public void run() {
				demo.await();
			}
		}).start();

		Thread.sleep(5000);

		new Thread(new Runnable() {

			@Override
			public void run() {
				demo.signal();
			}
		}).start();
	}
}
