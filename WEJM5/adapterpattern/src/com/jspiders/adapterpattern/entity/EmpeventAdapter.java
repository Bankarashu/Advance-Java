package com.jspiders.adapterpattern.entity;

public class EmpeventAdapter extends Employee implements Event{
	@Override
	public void womensDay() {
		System.out.println("Chef guest of the event is : " + this.name);
		System.out.println("Her Designation is : " + this.designation);
		
	}

}
