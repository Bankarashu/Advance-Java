package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.Account;

public class Person1 extends Thread {
	Account account;

	public Person1(Account account) {
		this.account = account;
	}
	@Override
	public void run() {
		account.depositAmount(5000);
		account.withdrawBalance(3000);
	}
	

}
