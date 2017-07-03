package com.dzg.study.day20170703;

public class ThreadA extends Thread{

	private Service service;
	
	public ThreadA(Service service){
		super();
		this.service = service;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		service.printA();
	}

}
