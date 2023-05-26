package com.jspiders.multithreading.main;

import com.jspiders.multithreading.resource.TrafficLight;
import com.jspiders.multithreading.thread.Tourist;
import com.jspiders.multithreading.thread.TrafficOfficer;

public class TrafficLightMain {
	public static void main(String[] args) {
		TrafficLight trafficLight=new TrafficLight("red");
		
		Tourist tourist=new Tourist(trafficLight);
		TrafficOfficer trafficOfficer=new TrafficOfficer(trafficLight);
		
		tourist.start();
		trafficOfficer.start();
	}

}











