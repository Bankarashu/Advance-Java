package com.jspiders.serializationdeserialization.object;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String userName;
	private String password;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password + "]";
	}
	 

		
}
