package com.jspiders.singleton.main;

import com.jspiders.singleton.object.SingletonEgar;
import com.jspiders.singleton.object.SingletonLazy;

public class SingletonMain {
	public static void main(String[] args) {
		SingletonLazy lazy = SingletonLazy.getObject();
		System.out.println(lazy);
		
		SingletonLazy lazy1 = SingletonLazy.getObject();
		System.out.println(lazy1);
		
		SingletonEgar egar = SingletonEgar.getObject();
		System.out.println(egar);
		
		SingletonEgar egar1 = SingletonEgar.getObject();
		System.out.println(egar1);
				
	}

}
