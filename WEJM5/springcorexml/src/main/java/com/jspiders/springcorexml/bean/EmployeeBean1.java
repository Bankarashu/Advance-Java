package com.jspiders.springcorexml.bean;

import java.util.List;

import lombok.Data;

@Data
public class EmployeeBean1 {
	int id;
	String name;
	double salary;
	List<CompanyBean1> companys;

}
