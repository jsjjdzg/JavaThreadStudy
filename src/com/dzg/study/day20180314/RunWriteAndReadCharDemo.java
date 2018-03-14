package com.dzg.study.day20180314;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class RunWriteAndReadCharDemo {
	public static void main(String[] args) throws IOException {
		ReadCharReader rcr = new ReadCharReader();
		WriteCharWrite wcr = new WriteCharWrite();

		PipedReader pr = new PipedReader();
		PipedWriter pw = new PipedWriter();

		pr.connect(pw);

		new Thread(new Runnable() {
			@Override
			public void run() {
				wcr.writeData(pw);
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				rcr.readData(pr);
			}
		}).start();
	}
}
