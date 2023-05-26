package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.TrafficLight;

public class Tourist extends Thread {
	TrafficLight trafficLight;

	public Tourist(TrafficLight trafficLight) {
		this.trafficLight = trafficLight;
	}
	
	@Override
	public void run() {
		trafficLight.safeJourney("green");
	}
	

}
