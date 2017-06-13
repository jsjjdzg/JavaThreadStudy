package com.dzg.study.day20170613;

/**
 * 
 * 为了防止脏读，需要对核心数据公共资源 synchronized(非this对象x) 来同步锁
 * 
 * @author DZG
 * @since V1.0 2017年6月13日
 */
public class MyListService {

	public MyList addOneName(MyList list, String name) {
		try {
			synchronized (list) {
				if (list.getSize() < 1) {
					Thread.sleep(1000);
					list.add(name);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
