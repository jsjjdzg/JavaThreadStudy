package com.dzg.study.day20180330D;

/**
 * 
 * 单例懒汉模式优化
 * 
 * @author DZG
 * @since V1.0 2018年3月30日
 */
public class SinglePatternDemoB {
	private static SinglePatternDemoB pattern;

	private SinglePatternDemoB() {

	}

	public SinglePatternDemoB getInstance() {
		if (pattern == null) {
			synchronized (SinglePatternDemoB.class) {
				if (pattern == null) {
					pattern = new SinglePatternDemoB();
				}
			}
		}
		return pattern;
	}
}
