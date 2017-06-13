package com.dzg.study.day20170613;

import java.util.ArrayList;
import java.util.List;

public class MyList {

	private List<String> list = new ArrayList<>();

	public void add(String name) {
		list.add(name);
	}

	public int getSize() {
		return list.size();
	}
}
