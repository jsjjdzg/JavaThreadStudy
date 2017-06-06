package com.dzg.study.day20170606;

/**
 * 
 * currentThread()
 * 
 * @author DZG
 * @since V1.0 2017年6月6日
 */
public class MyThreadA extends Thread{

	public MyThreadA(){
		System.out.println("MyThreadA 开始");
		System.out.println(Thread.currentThread().getName());
		System.out.println(this.getName());
		System.out.println("MyThreadA 结束");
	}
	
	@Override
	public void run(){
		System.out.println("MyThreadA run " + this.isAlive());
		System.out.println("MyThreadA run 开始");
		System.out.println(Thread.currentThread().getName());
		System.out.println(this.getName());
		System.out.println("MyThreadA run 结束");
	}
}
