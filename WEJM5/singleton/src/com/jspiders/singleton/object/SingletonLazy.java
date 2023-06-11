package com.jspiders.singleton.object;

public class SingletonLazy {
	
	private static SingletonLazy lazy;
	private static int count;
	
	private SingletonLazy() {
		count++;
		System.out.println("Object Created " + count + " times");
	}
	public static SingletonLazy getObject() {
		System.out.println("Trying to create object");
		if (lazy == null) {
			lazy = new SingletonLazy();
		}
		return lazy;
	}

}
