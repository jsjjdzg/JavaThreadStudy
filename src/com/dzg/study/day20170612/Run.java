package com.dzg.study.day20170612;

public class Run {

	public static void main(String[] args) {
		HasSalfNumber hn = new HasSalfNumber();
		RunThreadA a = new RunThreadA(hn);
		a.setName("a");
		a.start();
		RunThreadB b = new RunThreadB(hn);
		b.setName("b");
		b.start();
	}
}
