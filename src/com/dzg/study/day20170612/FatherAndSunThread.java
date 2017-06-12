package com.dzg.study.day20170612;

public class FatherAndSunThread extends Thread {

	@Override
	public void run() {
		super.run();
		ClassSun cs = new ClassSun();
		cs.executeB();
	}

}
