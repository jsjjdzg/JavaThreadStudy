package com.dzg.study.day20170704;

public class VolatileDemoRunA {

	public static void main(String[] args) {
		try {
			VolatileDemoThreadA run = new VolatileDemoThreadA();
			new Thread(run).start();
			Thread.sleep(3000);
			run.setIsGo(false);
			System.out.println("停止命令已下发");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
