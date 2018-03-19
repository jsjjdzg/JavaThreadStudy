package com.dzg.study.day20180319;

import java.util.Date;

public class InheritableThreadLocalDemo extends InheritableThreadLocal {
	protected Object initialValue() {
		return new Date().getTime();
	}

	@Override
	protected Object childValue(Object parentValue) {
		return parentValue + " 子线程中添加的字符串";
	}
}
