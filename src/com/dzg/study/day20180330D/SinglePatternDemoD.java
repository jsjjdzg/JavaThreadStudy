package com.dzg.study.day20180330D;

import java.io.Serializable;

/**
 * 
 * 序列化与反序列化的单例模式
 * 
 * @author DZG
 * @since V1.0 2018年3月30日
 */
public class SinglePatternDemoD implements Serializable {

	private static final long serialVersionUID = -8032586655489069073L;

	private static class SinglePatternDemoDInnoClass {
		private static SinglePatternDemoD pattern = new SinglePatternDemoD();
	}

	private SinglePatternDemoD() {

	}

	public SinglePatternDemoD getInstance() {
		return SinglePatternDemoDInnoClass.pattern;
	}

	protected Object readResolve() {
		return SinglePatternDemoDInnoClass.pattern;
	}
}
