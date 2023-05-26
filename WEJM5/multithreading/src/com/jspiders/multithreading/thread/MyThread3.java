package com.jspiders.multithreading.thread;

public class MyThread3 extends Thread{
	@Override
	public void run() {
		for(int i=1;i<=5;i++) {
		if(i>2) {
			this.stop();		
			}
		System.out.println("My Thread 3 is now running");
		}
	}

}
