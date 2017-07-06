package com.dzg.study.day20170706;

public class RunPAndS {

	public static void main(String[] args) {
		String lock = "lock";
		P p = new P(lock);
		S s = new S(lock);
		
		new PThread(p).start();
		new SThread(s).start();
	}
}
