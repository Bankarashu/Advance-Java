package com.jspiders.hibernate_file.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate_file.dto.EmployeeDTO;

public class EmployeeInsertDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("hibernate");
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

			EmployeeDTO emp1 = new EmployeeDTO();
			emp1.setId(1);
			emp1.setName("ROSHANI");
			emp1.setDesignation("ANALYST");
			emp1.setSalary(45000);

			EmployeeDTO emp2 = new EmployeeDTO();
			emp2.setId(2);
			emp2.setName("ASHWINI");
			emp2.setDesignation("MANAGER");
			emp2.setSalary(75000);

			EmployeeDTO emp3 = new EmployeeDTO();
			emp3.setId(3);
			emp3.setName("BHUMI");
			emp3.setDesignation("PRESIDENT");
			emp3.setSalary(55000);

			EmployeeDTO emp4 = new EmployeeDTO();
			emp4.setId(4);
			emp4.setName("DHRUV");
			emp4.setDesignation("ACCOUNTANT");
			emp4.setSalary(40000);

			manager.persist(emp1);
			manager.persist(emp2);
			manager.persist(emp3);
			manager.persist(emp4);

			transaction.commit();

		} finally {
			closeConnection();
		}
	}

}
