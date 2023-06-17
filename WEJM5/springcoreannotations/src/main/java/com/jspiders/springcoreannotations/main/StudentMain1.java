package com.jspiders.springcoreannotations.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springcoreannotations.beans.StudentBean1;
import com.jspiders.springcoreannotations.config.StudentConfig1;

public class StudentMain1 {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig1.class);
		
		StudentBean1 student1 = context.getBean(StudentBean1.class);
		System.out.println(student1);
		
		((AnnotationConfigApplicationContext)context).close();
	}

}
