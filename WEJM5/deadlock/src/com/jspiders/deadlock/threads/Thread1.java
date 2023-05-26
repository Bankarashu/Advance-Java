package com.jspiders.deadlock.threads;

import com.jspiders.deadlock.resource.Resource;

public class Thread1 extends Thread {
	Resource resource;

	public Thread1(Resource resource) {
		this.resource = resource;
	}
	
	@Override
	public void run() {
		synchronized (resource.resource1) {
			System.out.println(this.getName()+" got "+resource.resource1+" wainting for "+resource.resource2);
			synchronized (resource.resource2) {
				System.out.println(this.getName()+" got "+resource.resource2);
			}
			System.out.println(this.getName()+" gives "+resource.resource2);
		}
		System.out.println(this.getName()+" gives "+resource.resource1);
		System.out.println("Both drive safelly");
	}

}
