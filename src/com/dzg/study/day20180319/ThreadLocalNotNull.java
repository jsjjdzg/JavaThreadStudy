package com.dzg.study.day20180319;

public class ThreadLocalNotNull extends ThreadLocal {

	@Override
	protected Object initialValue() {
		return "我已经初始化过了";
	}
}
