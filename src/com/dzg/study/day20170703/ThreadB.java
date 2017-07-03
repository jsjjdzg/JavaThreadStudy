package com.dzg.study.day20170703;

public class ThreadB extends Thread{

	private Service service;
	
	public ThreadB(Service service){
		super();
		this.service = service;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void run() {
		service.printB();
	}

}
