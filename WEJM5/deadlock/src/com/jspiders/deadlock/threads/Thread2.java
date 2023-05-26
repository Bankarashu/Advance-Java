package com.jspiders.deadlock.threads;

import com.jspiders.deadlock.resource.Resource;

public class Thread2 extends Thread{
	Resource resource;

	public Thread2(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		synchronized (resource.resource2) {
			System.out.println(this.getName()+" got "+resource.resource2+" waiting for "+resource.resource1);
			synchronized (resource.resource1) {
				System.out.println(this.getName()+" got "+resource.resource1);				
			}
			System.out.println(this.getName()+" gives "+resource.resource1);
		}
		System.out.println(this.getName()+" gives "+resource.resource2);
		System.out.println("Both drive safelly");
	}
	
	
}
