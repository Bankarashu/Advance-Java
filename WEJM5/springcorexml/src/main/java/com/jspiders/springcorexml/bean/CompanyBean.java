package com.jspiders.springcorexml.bean;

import java.util.List;

import lombok.Data;

@Data
public class CompanyBean {
	int id;
	String name;
	String location;
	List<EmployeeBean> employees;

}
