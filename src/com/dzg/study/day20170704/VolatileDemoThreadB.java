package com.dzg.study.day20170704;

public class VolatileDemoThreadB extends Thread{

	volatile static private int count;
	
	/**
	 * 添加static关键词 可以使synchronized 是 类锁
	 * 
	 * @since 2017年7月4日
	 */
	synchronized private static void addCount(){
		for(int i = 0 ; i < 100 ; i++){
			count ++;
		}
		System.out.println("Count = " + count);
	}
	
	public void run(){
		addCount();
	}
}
