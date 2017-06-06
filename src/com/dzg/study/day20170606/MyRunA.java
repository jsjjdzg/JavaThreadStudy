package com.dzg.study.day20170606;

/**
 * 
 * isAlive(),sleep(),getId()
 * 
 * @author DZG
 * @since V1.0 2017年6月6日
 */
public class MyRunA {

	public static void main(String[] args) throws InterruptedException {
		MyThreadA m = new MyThreadA();
		Thread t = new Thread(m);
		// 线程不活动
		System.out.println("开始 ：" + t.isAlive());
		
		t.setName("A");
		t.start();
		
		System.out.println(t.getName() + " " + t.getId());
		//Thread.sleep(1000);
		// 线程活动 不确定是否还活动线程被执行完毕即不活动
		System.out.println("结束 ：" + t.isAlive());
	}

	/**
	MyThreadA 开始
	main
	Thread-0
	MyThreadA 结束
	
	MyThreadA run 开始
	A
	Thread-0
	MyThreadA run 结束
	*/
}
