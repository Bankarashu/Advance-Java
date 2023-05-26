package com.jspiders.multithreading.thread;

public class MyThread1 extends Thread  {
	@Override
	public void run() {
		System.out.println(this.getName());		
		System.out.println(this.getPriority());
	}
	

}
