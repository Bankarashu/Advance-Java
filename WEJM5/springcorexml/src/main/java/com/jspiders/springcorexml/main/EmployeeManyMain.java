package com.jspiders.springcorexml.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcorexml.bean.Company2Bean;

public class EmployeeManyMain {
	public static void main(String[] args) {
		ApplicationContext context =new ClassPathXmlApplicationContext("EmployeeManytoMain.xml");
		
		Company2Bean company1 = (Company2Bean)context.getBean("company1");
		Company2Bean company2 = (Company2Bean)context.getBean("company2");
		
		System.out.println(company1);
		System.out.println(company2);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
