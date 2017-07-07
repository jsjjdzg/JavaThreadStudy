package com.dzg.study.day20170707;

import java.io.PipedWriter;

/**
 * 
 * 管道字符流写入数据
 * 
 * @author DZG
 * @since V1.0 2017年7月7日
 */
public class WriteCharData {

	public void write(PipedWriter pw) {
		try {
			System.out.println("开始写入字符流");
			for (int i = 0; i < 100; i++) {
				String a = i + "";
				pw.write(a);
				System.out.print(a);
			}
			System.out.println();
			System.out.println("结束写入字符流");
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
