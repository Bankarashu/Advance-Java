package com.jspiders.hibernate_file.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate_file.dto.EmployeeDTO;

public class EmployeeUpdateDAO {
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
				
			EmployeeDTO employee = manager.find(EmployeeDTO.class, 2);
			employee.setDesignation("SALESMAN");
			manager.persist(employee);
			
			transaction.commit();
			
		} finally {
				closeConnection();
		}
	}
}
