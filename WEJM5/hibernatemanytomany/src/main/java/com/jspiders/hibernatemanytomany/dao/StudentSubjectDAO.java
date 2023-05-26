package com.jspiders.hibernatemanytomany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatemanytomany.dto.StudentsDTO;
import com.jspiders.hibernatemanytomany.dto.SubjectDTO;

public class StudentSubjectDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("ManyToMany");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if(factory != null) {
			factory.close();
		}
		if(manager != null) {
			manager.close();
		}
		if(transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	
	public static void main(String[] args) {
		try {
			openConnection();
			transaction.begin();
			
			SubjectDTO subject1 = new SubjectDTO();
			subject1.setId(1);
			subject1.setName("Core Java");
			subject1.setDuration(3);
			manager.persist(subject1);
			
			SubjectDTO subject2 = new SubjectDTO();
			subject2.setId(2);
			subject2.setName("Advance Java");
			subject2.setDuration(3);
			manager.persist(subject2);
			
		List<SubjectDTO> subject = Arrays.asList(subject1, subject2);
		
		
		StudentsDTO student1 = new StudentsDTO();
		student1.setId(1);
		student1.setName("ASHWINI");
		student1.setEmail("ashwini@gmail.com");
		student1.setAddress("PUNE");
		student1.setSubjects(subject);
		manager.persist(student1);
		
		StudentsDTO student2 = new StudentsDTO();
		student2.setId(2);
		student2.setName("ROHIT");
		student2.setEmail("rohit@gmail.com");
		student2.setAddress("BARAMATI");
		student2.setSubjects(subject);
		manager.persist(student2);
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}

}
