package com.dzg.study.day20180330C;

import java.util.Calendar;
import java.util.Timer;

/**
 * 
 * TimerTask执行
 * 
 * @author DZG
 * @since V1.0 2018年3月30日
 */
public class TimerTaskRunDemo {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.SECOND, 10);
		TimerTaskDemo task = new TimerTaskDemo();
		Timer timer = new Timer(); // 运行结束不会关闭，是启动了一个不关闭的线程
		// Timer timer = new Timer(true); // 守护线程，运行完直接关闭线程，定时任务没执行
		timer.schedule(task, c.getTime());
	}
}
