package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.bean.EmployeeBean1;

public class Employee1Main {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("EmployeeConfig.xml");
		
		EmployeeBean1 employee1 = (EmployeeBean1)context.getBean("employee1");
		EmployeeBean1 employee2 = (EmployeeBean1)context.getBean("employee2");
		
		System.out.println(employee1);
		System.out.println(employee2);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
