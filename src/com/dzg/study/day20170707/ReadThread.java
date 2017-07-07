package com.dzg.study.day20170707;

import java.io.PipedInputStream;
import java.io.PipedReader;

/**
 * 
 * 读取线程
 * 
 * @author DZG
 * @since V1.0 2017年7月7日
 */
public class ReadThread extends Thread {

	private ReadData r;
	private PipedInputStream pis;
	private PipedReader pr;
	private ReadCharData rcd;

	public ReadThread(ReadData r, PipedInputStream pis) {
		super();
		this.r = r;
		this.pis = pis;
	}

	public ReadThread(PipedReader pr, ReadCharData rcd) {
		super();
		this.pr = pr;
		this.rcd = rcd;
	}

	public void run2() {
		r.readData(pis);
	}

	public void run() {
		rcd.read(pr);
	}
}
