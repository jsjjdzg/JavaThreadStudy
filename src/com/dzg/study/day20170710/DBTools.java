package com.dzg.study.day20170710;

/**
 * 
 * 自我阻塞交叉工作
 * 
 * @author DZG
 * @since V1.0 2017年7月10日
 */
public class DBTools {

	// volatile 可用可不用，因为下列方法都是同步的
	volatile private boolean isGo = false;

	synchronized public void blackGo() {
		try {
			if (isGo == true) {
				wait();
			}
			for (int i = 0; i < 3; i++) {
				System.out.println("黑黑黑黑黑");
			}
			isGo = true;// 自己将自己阻塞
			notifyAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	synchronized public void whiteGo() {
		try {
			if (isGo == false) {
				wait();
			}
			for (int i = 0; i < 3; i++) {
				System.out.println("白白白白白");
			}
			isGo = false;// 自己将自己阻塞
			notifyAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
