package com.dzg.study.day20170609;

/**
 * 
 * 停止线程
 * 推荐使用抛异常来停止线程，这样可以捕捉异常来进行相关处理
 * 也可以使用 return 配合 interrupt来停止
 * 
 * @author DZG
 * @since V1.0 2017年6月9日
 */
public class InterruptThreadDemo extends Thread {

	/**
	 * 可以使用 ： interrupt() 和 return 结合停止线程
	 */
	@Override
	public void run() {
		while(true){
			if(this.isInterrupted()){
				System.out.println("停止线程");
				return;
			}
			System.out.println(System.currentTimeMillis());
		}
	}
	
		
	/**
	 * 使用异常停止线程
	 */
/*	@Override
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 500000; i++) {
				if (this.isInterrupted()) {
					System.out.println("停止线程");
					throw new InterruptedException();// 线程停止抛出异常
				}
				System.out.println("i = " + i);
			}
			System.out.println("输出，for结束");
		} catch (InterruptedException e) {
			System.out.println("进入异常catch方法");
			e.printStackTrace();
		}
	}*/
	
	/**
	 * 在睡眠中sleep()中停止线程
	 */
/*	@Override
	public void run() {
		super.run();
		try {
			for (int i = 0; i <= 20000; i++) {
				System.out.println("i = " + i);
			}
			System.out.println("begin");
			Thread.sleep(100000);
			System.out.println("end");
		} catch (InterruptedException e) {
			System.out.println("睡眠中被停止线程");
			e.printStackTrace();
		}
	}*/
	
	/**
	 * stop()暴力停止线程(不使用)
	 * 会导致流程破坏，比如流程为走完，被停止
	 * 
	 */
/*	@Override
	public void run() {
		int i = 0;
		super.run();
		try {
			while(true){
				i++;
				System.out.println("i = " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("睡眠中被停止线程");
			e.printStackTrace();
		}
	}*/	
/*	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		super.run();
		try {
			this.stop();// stop方法会隐式抛出ThreadDeath异常
		} catch (ThreadDeath e) {
			System.out.println("stop()方法抛出了ThreadDeath异常");
			e.printStackTrace();
		}
	}*/
}
