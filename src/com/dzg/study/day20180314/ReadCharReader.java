package com.dzg.study.day20180314;

import java.io.PipedReader;

public class ReadCharReader {

	public void readData(PipedReader pr) {
		try {
			System.out.println("字符流开始读取");
			char[] charArray = new char[50];
			int size = pr.read(charArray);
			while (size != -1) {
				String data = new String(charArray, 0, size);
				System.out.print(data);
				size = pr.read(charArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
