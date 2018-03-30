package com.dzg.study.day20180330C;

import java.util.TimerTask;

/**
 * 
 * TimerTask实例
 * 
 * @author DZG
 * @since V1.0 2018年3月30日
 */
public class TimerTaskDemo extends TimerTask{

	@Override
	public void run() {
		System.out.println("执行了一次任务");
	}
}
