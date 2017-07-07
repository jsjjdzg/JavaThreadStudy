package com.dzg.study.day20170707;

import java.io.PipedInputStream;

/**
 * 
 * PipedInputStream 字节流 读取数据
 * 
 * @author DZG
 * @since V1.0 2017年7月6日
 */
public class ReadData {

	public void readData(PipedInputStream in) {
		try {
			System.out.println("开始读取");
			byte[] byteArray = new byte[200];
			int length = in.read(byteArray); // 若是没有数据会被一直阻塞，直到有数据为止
			while (length != -1) {
				String newData = new String(byteArray, 0, length);
				System.out.print(newData);
				length = in.read(byteArray);
			}
			System.out.println();
			System.out.println("读取完毕");
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
