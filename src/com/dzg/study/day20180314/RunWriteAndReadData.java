package com.dzg.study.day20180314;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class RunWriteAndReadData {

	public static void main(String[] args) throws IOException, InterruptedException {
		WriteByteData wd = new WriteByteData();
		ReadByteData rd = new ReadByteData();

		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();

		in.connect(out);

		new Thread(new Runnable() {
			@Override
			public void run() {
				rd.readData(in);
			}
		}).start();
		
		Thread.sleep(2000);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				wd.writeData(out);
			}
		}).start();
		
	}
}
