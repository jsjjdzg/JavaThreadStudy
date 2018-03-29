package com.dzg.study.day20180319B;

public class BankMoney {
	private Integer money;

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public void remove100() {
		setMoney(getMoney() - 100);
	}
}
