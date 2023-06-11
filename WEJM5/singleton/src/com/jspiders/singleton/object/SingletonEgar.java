package com.jspiders.singleton.object;

public class SingletonEgar {
	private static SingletonEgar egar = new SingletonEgar();
	
	private static int count;
	
	private SingletonEgar() {
		count++;
	}
	public static SingletonEgar getObject() {
		System.out.println("Trying to create object");
		return egar;
	}

}
