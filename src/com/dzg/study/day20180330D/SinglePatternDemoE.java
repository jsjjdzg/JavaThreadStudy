package com.dzg.study.day20180330D;

/**
 * 
 * 使用静态代码块实现单例模式
 * 
 * @author DZG
 * @since V1.0 2018年3月30日
 */
public class SinglePatternDemoE {

	private static SinglePatternDemoE pattern;

	private SinglePatternDemoE() {

	}

	static {
		pattern = new SinglePatternDemoE();
	}

	public SinglePatternDemoE getInstance() {
		return pattern;	
	}
}
