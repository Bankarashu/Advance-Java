package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.bean.StudentBean;

public class StudentMain {
	public static void main(String[] args) {
	ApplicationContext context = new ClassPathXmlApplicationContext("StudentConfig.xml");
	
	StudentBean student = context.getBean(StudentBean.class);
	StudentBean student1 = (StudentBean)context.getBean("student1");
	System.out.println(student);
	System.out.println(student1);
	
	((ClassPathXmlApplicationContext)context).close();
	}
}
