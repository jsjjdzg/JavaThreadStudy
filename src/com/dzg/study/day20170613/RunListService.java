package com.dzg.study.day20170613;

public class RunListService {

	public static void main(String[] args) throws InterruptedException {
		MyList list = new MyList();
		ListThreadA a = new ListThreadA(list);
		a.start();
		ListThreadB b = new ListThreadB(list);
		b.start();
		System.out.println(list.getSize());
		Thread.sleep(2000);
		System.out.println(list.getSize());
	}
}
