package com.dzg.study.day20170707;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * 
 * 管道字节流通信
 * 
 * @author DZG
 * @since V1.0 2017年7月7日
 */
public class ReadAndWriteRun {

	public static void main(String[] args) {
		try {
			WriteCharData wcd = new WriteCharData();
			ReadCharData rcd = new ReadCharData();

			PipedReader pr = new PipedReader();
			PipedWriter pw = new PipedWriter();

			WriteThread wt = new WriteThread(pw, wcd);
			ReadThread rt = new ReadThread(pr, rcd);

			pr.connect(pw);
			//pw.connect(pr);

			wt.start();
			Thread.sleep(500);
			rt.start();

			// PipedInputStream pis = new PipedInputStream();
			// PipedOutputStream pos = new PipedOutputStream();
			
			// WriteData w = new WriteData();
			// ReadData r = new ReadData();

			// WriteThread wt = new WriteThread(w, pos);
			// ReadThread rt = new ReadThread(r, pis);

			// pos.connect(pis);
			// pis.connect(pos); // 需要先连接

			// wt.start();
			// Thread.sleep(2000);
			// rt.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
