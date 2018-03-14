package com.dzg.study.day20180314;

public class RunDBToolDemo {

	public static void main(String[] args) {
		try {
			DBTools db = new DBTools();

			for (int i = 0; i < 20; i++) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						db.popBlack();
					}
				}).start();
				new Thread(new Runnable() {
					@Override
					public void run() {
						db.popWhite();
					}
				}).start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
