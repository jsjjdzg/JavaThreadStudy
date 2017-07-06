package com.dzg.study.day20170706;

import java.util.ArrayList;
import java.util.List;

public class AddAndSubRun {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Object lock = new Object();
		
		SubWaitThread s1 = new SubWaitThread(list, lock);
		s1.setName("s1");
		s1.start();
		
		SubWaitThread s2 = new SubWaitThread(list, lock);
		s2.setName("s2");
		s2.start();
		
		AddNotifyThread a = new AddNotifyThread(list, lock);
		a.start();	
	}
}
