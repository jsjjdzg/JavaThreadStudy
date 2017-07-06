package com.dzg.study.day20170706;

/**
 * 
 * 生产者
 * 
 * @author DZG
 * @since V1.0 2017年7月6日
 */
public class P {

	private String lock;

	public P(String lock) {
		super();
		this.lock = lock;
	}

	public void setValue() {
		try {
			synchronized (lock) {
				if (!ValueObject.value.equals("")) {
					lock.wait();
				}
				String value = System.currentTimeMillis() + "";
				System.out.println("Set值为 " + value);
				ValueObject.value = value;
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
