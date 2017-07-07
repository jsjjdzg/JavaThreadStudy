package com.dzg.study.day20170707;

import java.io.PipedReader;

/**
 * 
 * 管道数据量读取数据
 * 
 * @author DZG
 * @since V1.0 2017年7月7日
 */
public class ReadCharData {

	public void read(PipedReader pr) {
		try {
			System.out.println("开始读取字符流");
			char[] charArray = new char[100];
			int length = pr.read(charArray);
			while (length != -1) {
				String str = new String(charArray, 0, length);
				System.out.print(str);
				length = pr.read(charArray);
			}
			System.out.println();
			System.out.println("结束读取字符流");
			pr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
