package com.jspiders.springcoreannotations.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.springcoreannotations.beans.StudentBean;

public class StudentConfig {
	
	@Bean("student1")
	public StudentBean getStudent() {
		StudentBean student = new StudentBean();
		student.setId(1);
		student.setName("Roshani");
		student.setEmail("roshiani@gamil.com");
		
		return student;
	}

}
