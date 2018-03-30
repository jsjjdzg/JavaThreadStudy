package com.dzg.study.day20180330D;

/**
 * 
 * 静态内部类实现单例模式
 * 
 * @author DZG
 * @since V1.0 2018年3月30日
 */
public class SinglePatternDemoC {

	private static class SinglePatternDemoCInnoClass {
		private static SinglePatternDemoC pattern = new SinglePatternDemoC();
	}

	private SinglePatternDemoC() {

	}

	public SinglePatternDemoC getInstance() {
		return SinglePatternDemoCInnoClass.pattern;
	}
}
