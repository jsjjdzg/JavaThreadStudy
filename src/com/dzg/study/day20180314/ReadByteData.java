package com.dzg.study.day20180314;

import java.io.PipedInputStream;

public class ReadByteData {

	public void readData(PipedInputStream in) {
		try {
			System.out.println("开始读取");
			byte[] byteArray = new byte[100];// 一次读一定数量的字节
			int size = in.read(byteArray);// 只要能读到都大于1
			while (size != -1) {
				String newData = new String(byteArray, 0, size);// 一次读取字节数，0，可读取到的字节数
				System.out.print(newData);
				size = in.read(byteArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
