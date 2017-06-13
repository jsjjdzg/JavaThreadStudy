package com.dzg.study.day20170613;

public class ListThreadA extends Thread {

	private MyList list;

	public ListThreadA(MyList list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		super.run();
		MyListService service = new MyListService();
		service.addOneName(list, "A");
	}

}
