package com.dzg.study.day20170612;

/**
 * 
 * synchronized 强制让该方法同步
 * 
 * @author DZG
 * @since V1.0 2017年6月12日
 */
public class HasSalfNumber {

	private int num;

	synchronized public void addNum(String name) {
		try {
			if (name.equals("a")) {
				num = 100;
				System.out.println("a set num over");
				Thread.sleep(2000);
			} else {
				num = 200;
				System.out.println("b set num over");
			}
			System.out.println(name + " number is " + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试异常是否能中断锁
	 * 异常中断锁，释放锁，其他线程正常调用
	 * 
	 * @since 2017年6月12日
	 */
	synchronized public void testExceptionThreadStop() {
		if (Thread.currentThread().getName().equals("a")) {
			int i = 5;
			while (i > 0) {
				i--;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("进入a逻辑");
				Integer.parseInt("a");
			}
		} else {
			System.out.println("进入b逻辑");
		}
	}

	/**
	 * 同时调用addNumB()方法需要排队进入锁
	 * 
	 * @since 2017年6月12日
	 */
	synchronized public void addNumB() {
		try {
			Thread.sleep(2000);
			System.out.println(" addNumB is " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * addNumC()是异步的可以同时进行，但是资源共享下需要注意线程安全，反之不需要
	 * 
	 * @since 2017年6月12日
	 */
	public void addNumC() {
		try {
			Thread.sleep(500);
			System.out.println(" addNumC is " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
