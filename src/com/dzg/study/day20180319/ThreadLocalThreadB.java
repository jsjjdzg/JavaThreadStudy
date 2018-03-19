package com.dzg.study.day20180319;

public class ThreadLocalThreadB extends Thread {

	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				ThreadLocalTool.t1.set(i + 1);
				System.out.println("ThreadB:" + ThreadLocalTool.t1.get());
				Thread.sleep(200);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
