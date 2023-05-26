package com.jspiders.multithreading.resource;

public class TrafficLight {
	
	String lightColor;

	public TrafficLight(String lightColor) {
		this.lightColor = lightColor;
	}
	
	public synchronized void safeJourney(String choosenColor) {
		System.out.println("want to Enjoy Journey with "+choosenColor+" color...!!!");
		if(lightColor.contentEquals(choosenColor)) {
			System.out.println("Enjoy u r journey bcuz u choose "+choosenColor);
		}
		else {
			System.out.println("You choose "+choosenColor+" but its time to rest...!!!");
			System.out.println("Plz... Wait");
			try {
				this.wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		 
	}
	
	public synchronized void makeSafeJourney(String choosenColor) {
		System.out.println("changing traffic light to Green...!!!");
		lightColor=choosenColor;
		this.notify();
		System.out.println("Enjoy u r journey....!!!!!");
	}
	

}
