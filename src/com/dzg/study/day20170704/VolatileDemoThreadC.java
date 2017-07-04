package com.dzg.study.day20170704;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * 原子类 AtomicXXX 执行原子操作
 * 
 * @author DZG
 * @since V1.0 2017年7月4日
 */
public class VolatileDemoThreadC extends Thread {

	// 原子类 AtomicXXX
	private AtomicInteger count = new AtomicInteger(0);

	public void run() {
		for (int i = 0; i < 100; i++) {
			//  以原子方式将当前值加 1。
			System.out.println(count.incrementAndGet());
		}
	}
}
