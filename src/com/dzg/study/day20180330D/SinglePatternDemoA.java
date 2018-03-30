package com.dzg.study.day20180330D;

/**
 * 
 * 单例饿汉模式
 * 
 * @author DZG
 * @since V1.0 2018年3月30日
 */
public class SinglePatternDemoA {

	private static SinglePatternDemoA pattern = new SinglePatternDemoA();

	private SinglePatternDemoA() {
	};

	public SinglePatternDemoA getInstance() {
		return pattern;
	}
}
