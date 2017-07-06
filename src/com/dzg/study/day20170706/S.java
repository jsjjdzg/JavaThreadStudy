package com.dzg.study.day20170706;

/**
 * 
 * 消费者
 * 
 * @author DZG
 * @since V1.0 2017年7月6日
 */
public class S {

	private String lock;

	public S(String lock) {
		super();
		this.lock = lock;
	}

	public void getValue() {
		try {
			synchronized (lock) {
				if (ValueObject.value.equals("")) {
					lock.wait();
				}
				System.out.println("Get值为 " + ValueObject.value);
				ValueObject.value = "";
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
