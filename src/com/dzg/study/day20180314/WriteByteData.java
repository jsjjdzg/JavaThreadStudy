package com.dzg.study.day20180314;

import java.io.PipedOutputStream;

public class WriteByteData {

	public void writeData(PipedOutputStream out) {
		try {
			System.out.println("开始写入");
			out.write("永生之酒永生之酒永生之酒永生之酒永生之酒".getBytes());
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
