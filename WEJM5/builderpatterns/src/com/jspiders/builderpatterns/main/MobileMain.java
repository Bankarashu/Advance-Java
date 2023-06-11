package com.jspiders.builderpatterns.main;

import com.jspiders.builderpatterns.builder.MobileBuilder;
import com.jspiders.builderpatterns.objects.Mobile;

public class MobileMain {
	public static void main(String[] args) {
		Mobile mobile = new MobileBuilder().brand("Samsung").model("S23").memory(256).colour("Black").getMobile();
		System.out.println(mobile);

	}

}
