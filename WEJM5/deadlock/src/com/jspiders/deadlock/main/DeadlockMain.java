package com.jspiders.deadlock.main;

import com.jspiders.deadlock.resource.Resource;
import com.jspiders.deadlock.threads.Thread1;
import com.jspiders.deadlock.threads.Thread2;

public class DeadlockMain {
	public static void main(String[] args) {
		
		Resource resource=new Resource();
		
		Thread1 thread1=new Thread1(resource);
		thread1.setName("Roshani");
		
		Thread2 thread2=new Thread2(resource);
		thread2.setName("Battery");
		
		thread1.start();
		thread2.start();
		
	}

}
