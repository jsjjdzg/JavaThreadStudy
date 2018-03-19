package com.dzg.study.day20180319;

public class InheritableThreadLocalThreadA extends Thread {
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(ThreadLocalTool.t2.get());
				Thread.sleep(200);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
