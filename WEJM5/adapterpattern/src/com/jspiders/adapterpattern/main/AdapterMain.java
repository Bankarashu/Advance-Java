package com.jspiders.adapterpattern.main;

import com.jspiders.adapterpattern.entity.EmpeventAdapter;

public class AdapterMain {
	public static void main(String[] args) {
		 EmpeventAdapter adapter = new EmpeventAdapter();
		 adapter.name = "Roshani";
		 adapter.email = "roshani@gmail.com";
		 adapter.contact = 7768036990l;
		 adapter.designation = "Full Stack Developer";
		 adapter.womensDay();
	}

}
