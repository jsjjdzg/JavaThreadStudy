package com.dzg.study.day20170703;

public class StaticInnerClassAndInnerClass {

	public String name;
	public String password;
	public static int code;

	public class InnerClass{
		//public static int code2;
		public void exe(){
			System.out.println(name + password);
			System.out.println(code);
		}
	}
	
	public static class StaticInnerClass{
		public static int code2;
		public void exe(){
			//System.out.println(name + password);
			System.out.println(code);
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
