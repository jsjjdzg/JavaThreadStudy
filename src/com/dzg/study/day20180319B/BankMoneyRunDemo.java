package com.dzg.study.day20180319B;

/**
 * 
 * 相互取钱的问题
 * 
 * @author DZG
 * @since V1.0 2018年3月21日
 */
public class BankMoneyRunDemo {

	public static void main(String[] args) {
		BankMoney money = new BankMoney();
		money.setMoney(500);

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 5; i++) {
						synchronized (money) {
							if (money.getMoney() > 0) {
								System.out.println(Thread.currentThread().getName() + " 正在取100元");
								money.remove100();
							} else {
								System.out.println(Thread.currentThread().getName() + "取钱，但并没有钱了");
							}
							Thread.sleep(2000);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, " X男X ").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 5; i++) {
						synchronized (money) {
							if (money.getMoney() > 0) {
								System.out.println(Thread.currentThread().getName() + " 正在取100元");
								money.remove100();
							} else {
								System.out.println(Thread.currentThread().getName() + "取钱，但并没有钱了");
							}
							Thread.sleep(2000);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, " X女X ").start();
	}
}
