package com.dzg.study.day20180319;

public class ThreadLocalDemo1 {

	public static ThreadLocalNotNull t1 = new ThreadLocalNotNull();

	public static void main(String[] args) {
		if (t1.get() == null) {
			System.out.println("没有值");
			t1.set("我放入值了");
		}
		System.out.println("X:" + t1.get());
		System.out.println("XXX:" + t1.get());
	}
}
