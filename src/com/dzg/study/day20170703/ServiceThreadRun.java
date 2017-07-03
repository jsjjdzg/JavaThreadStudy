package com.dzg.study.day20170703;

public class ServiceThreadRun {

	public static void main(String[] args) {
		Service service = new Service();
		ThreadA a = new ThreadA(service); 
		a.setName("a");
		a.start();
		ThreadB b = new ThreadB(service); 
		b.setName("b");
		b.start();
		ThreadC c = new ThreadC(service); 
		c.setName("c");
		c.start();
	}
}
