package com.jspiders.multithreading.resource;

public class Account {
	int accountBalance;

	public Account(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public void checkBalance() {
		System.out.println("Current Balance:"+accountBalance);
	}
	public synchronized void depositAmount(int amount) {
		System.out.println("Depositing "+amount+" rs in account");
		accountBalance+=amount;
		checkBalance();
	}
	public synchronized void withdrawBalance(int amount) {
		System.out.println("Trying to withdraw "+amount+" rs form account.");
		if(amount>accountBalance) {
			System.out.println("Insufficient Balance");
		}else {
			accountBalance-=amount;
			checkBalance();
		}
	}
	

}
