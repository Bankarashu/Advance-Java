package com.jspiders.springcoreannotations.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcoreannotations.beans.StudentBean1;

public class StudentConfig1 {
	@Bean("studnet1")
	public StudentBean1 getStudent() {
		return new StudentBean1();
	}

}
