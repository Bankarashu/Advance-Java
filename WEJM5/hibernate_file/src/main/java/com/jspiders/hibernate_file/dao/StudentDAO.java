package com.jspiders.hibernate_file.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate_file.dto.StudentDTO;

public class StudentDAO {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		
		StudentDTO student1 = new StudentDTO();
		student1.setSid(1);
		student1.setSname("ROSHANI");
		student1.setSadd("PUNE");
		student1.setSmarks(75);
		student1.setSemail("roshani@gmail.com");
		
		entityManager.persist(student1);
		entityTransaction.commit();
		
		if (entityManagerFactory != null) {
			entityManager.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction.isActive()) {
			entityTransaction.rollback();
		}
		
	}

}
