package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.TrafficLight;

public class TrafficOfficer extends Thread {
	TrafficLight trafficLight;

	public TrafficOfficer(TrafficLight trafficLight) {
		this.trafficLight = trafficLight;
	}
	
	@Override
	public void run() {
		trafficLight.makeSafeJourney("green");
	}
}
