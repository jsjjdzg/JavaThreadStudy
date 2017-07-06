package com.dzg.study.day20170706;

import java.util.List;

public class AddNotifyThread extends Thread {

	private List<String> list;
	private Object lock;

	public AddNotifyThread(List<String> list, Object lock) {
		super();
		this.list = list;
		this.lock = lock;
	}

	public void run() {
		synchronized(lock){
			list.add("abc");
			lock.notifyAll();
		}
	}

}
