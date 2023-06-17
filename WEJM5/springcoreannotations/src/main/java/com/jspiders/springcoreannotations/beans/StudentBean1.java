package com.jspiders.springcoreannotations.beans;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class StudentBean1 {
	@Value("1")
	int id;
	@Value("Ashu")
	String name;
	@Value("ashu@gmail.com")
	String email;

}
