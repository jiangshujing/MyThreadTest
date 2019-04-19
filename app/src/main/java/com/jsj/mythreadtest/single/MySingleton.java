package com.jsj.mythreadtest.single;

public class MySingleton {
	private static MySingleton instance = new MySingleton();
 
	private MySingleton() {
	}
 
	public static MySingleton getInstance() {
		return instance;
	}

	//多线程调用单利模式类的同一个方法是不用排队的，是同时一起调用的
	public  void printName(String name) {
		System.out.println(name+"开始调用");
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+"结束调用");
	}
}

