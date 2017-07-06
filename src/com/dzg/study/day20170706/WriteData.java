package com.dzg.study.day20170706;

import java.io.PipedOutputStream;

/**
 * 
 * PipedOutputStream 字节流 写入数据
 * 
 * @author DZG
 * @since V1.0 2017年7月6日
 */
public class WriteData {

	public void write(PipedOutputStream out) {
		try {
			System.out.println("开始写入");
			for (int i = 0; i < 100; i++) {
				String b = i + "";
				out.write(b.getBytes());
				System.out.print(b);
			}
			System.out.println("写入完毕");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
