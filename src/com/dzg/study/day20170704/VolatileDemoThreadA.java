package com.dzg.study.day20170704;

/**
 * 
 * Volatile关键字
 * 
 * 使变量在多个线程间可见 
 * ==> 强制从公共堆栈取得变量的值，不是从线程私有数据栈中取变量的值
 * 
 * @author DZG
 * @since V1.0 2017年7月4日
 */
public class VolatileDemoThreadA implements Runnable {

	// 强制从公共内存中读取
	volatile private boolean isGo = true;

	public void setIsGo(boolean isGo) {
		this.isGo = isGo;
	}

	@Override
	public void run() {
		try {
			String anything = new String();
			while (isGo == true) {
				// 可以使其他线程看到锁修改的对象
				// 例如 A在运行，B修改了isGo，但是A不知道，添加同步使A线程知道
				synchronized(anything){}
				System.out.println("当前线程为" + Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
