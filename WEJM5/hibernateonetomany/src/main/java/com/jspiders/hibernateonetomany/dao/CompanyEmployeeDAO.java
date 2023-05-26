package com.jspiders.hibernateonetomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetomany.dto.CompanyDTO;
import com.jspiders.hibernateonetomany.dto.EmployeesDTO;


public class CompanyEmployeeDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("OneToMany");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}

	public static void main(String[] args) {
		try {
			openConnection();
			transaction.begin();
			
			EmployeesDTO employee1 = new EmployeesDTO();
			employee1.setId(1);
			employee1.setName("ASHWINI");
			employee1.setDesignation("ANALYST");
			employee1.setEmail("ashwini@gmail.com");
			employee1.setSalary(45000);
			manager.persist(employee1);
			
			EmployeesDTO employee2 = new EmployeesDTO();
			employee2.setId(2);
			employee2.setName("ROHIT");
			employee2.setDesignation("SALESMAN");
			employee2.setEmail("rohit@gmail.com");
			employee2.setSalary(420);
			manager.persist(employee2);
			
			EmployeesDTO employee3 = new EmployeesDTO();
			employee3.setId(3);
			employee3.setName("DHRUV");
			employee3.setDesignation("MANAGER");
			employee3.setEmail("dhruv@gmail.com");
			employee3.setSalary(75000);
			manager.persist(employee3);
			
			List<EmployeesDTO> employees = Arrays.asList(employee1, employee2, employee3);
			
			CompanyDTO company = new CompanyDTO();
			company.setId(1);
			company.setAddress("PUNE");
			company.setDoe("01-07-1999");
			company.setName("Tech Mahindra");
			company.setEmployees(employees);
			manager.persist(company);

			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
}
