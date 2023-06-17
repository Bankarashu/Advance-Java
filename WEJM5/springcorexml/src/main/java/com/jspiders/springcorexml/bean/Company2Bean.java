package com.jspiders.springcorexml.bean;

import java.util.List;

import lombok.Data;

@Data
public class Company2Bean {
	int id;
	String name;
	String location;
	List<Employee2Bean> employees;

}
