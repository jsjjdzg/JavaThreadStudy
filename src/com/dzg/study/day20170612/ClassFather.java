package com.dzg.study.day20170612;

public class ClassFather {

	public int i = 10;

	synchronized public void execute() {
		try {
			i--;
			Thread.sleep(100);
			System.out.println("Father's i = " + i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
