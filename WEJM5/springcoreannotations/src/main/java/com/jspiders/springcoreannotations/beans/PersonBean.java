package com.jspiders.springcoreannotations.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data

public class PersonBean {
	@Value("1")
	int id;
	@Value("Dhruv")
	String name;
	@Value("dhruv@gmail.com")
	String email;
	@Autowired
	AadharBean aadhar;

}
