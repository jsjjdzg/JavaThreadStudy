package com.dzg.study.day20170706;

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
			byte[] readArray = new byte[100];
			int length = in.read(readArray);
			while (length != -1) {
				String newData = new String(readArray, 0, length);
				System.out.print(newData);
				length = in.read(readArray);
			}
			System.out.println("读取完毕");
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
