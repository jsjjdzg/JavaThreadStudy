package com.dzg.study.day20180314;

/**
 * 
 * 交叉备份Demo
 * 
 * @author DZG
 * @since V1.0 2018年3月14日
 */
public class DBTools {

	volatile private boolean isBlack = true;

	synchronized public void popBlack() {
		try {
			while (isBlack == true) {
				wait();
			}
			System.out.println("黑");
			notifyAll();
			isBlack = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	synchronized public void popWhite() {
		try {
			while (isBlack == false) {
				wait();
			}
			System.out.println("白");
			notifyAll();
			isBlack = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
