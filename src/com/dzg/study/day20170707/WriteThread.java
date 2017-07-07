package com.dzg.study.day20170707;

import java.io.PipedOutputStream;
import java.io.PipedWriter;

/**
 * 
 * 写入线程
 * 
 * @author DZG
 * @since V1.0 2017年7月7日
 */
public class WriteThread extends Thread {

	private WriteData w;
	private PipedOutputStream pos;
	private PipedWriter pw;
	private WriteCharData wcd;

	public WriteThread(WriteData w, PipedOutputStream pos) {
		super();
		this.w = w;
		this.pos = pos;
	}
	
	public WriteThread(PipedWriter pw, WriteCharData wcd) {
		super();
		this.wcd = wcd;
		this.pw = pw;
	}

	public void run2() {
		w.write(pos);
	}
	
	public void run() {
		wcd.write(pw);
	}
}
