package com.dzg.study.day20170612;

public class ClassSun extends ClassFather {

	synchronized public void executeB() {
		try {
			while (i > 0) {
				i--;
				Thread.sleep(100);
				System.out.println("Sun's i = " + i);
				this.execute();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
