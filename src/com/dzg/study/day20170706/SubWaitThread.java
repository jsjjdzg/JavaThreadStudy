package com.dzg.study.day20170706;

import java.util.List;

public class SubWaitThread extends Thread {

	private List<String> list;
	private Object lock;

	public SubWaitThread(List<String> list, Object lock) {
		super();
		this.list = list;
		this.lock = lock;
	}

	public void run() {
		synchronized (lock) {
			try {
				// wait() 需要放在while内部，每次notify wait都要检测条件是否满足
				while (list.size() == 0) {
					System.out.println("wait begin Thread Name = " + Thread.currentThread().getName());
					lock.wait();
					System.out.println("wait end Thread Name = " + Thread.currentThread().getName());
				}
				list.remove(0);
				System.out.println("wait over Thread Name = " + Thread.currentThread().getName());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
