package com.dzg.study.day20180314;

import java.io.PipedWriter;

public class WriteCharWrite {

	public void writeData(PipedWriter pw) {
		try {
			System.out.println("字符流开始写入");
			pw.write("永生之酒222永生之酒333永生之酒444永生之酒555");
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
