package com.jspiders.hibernateonetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernateonetoone.dto.AadharDTO;
import com.jspiders.hibernateonetoone.dto.PersonDTO;

public class PersonAadharDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("OneToOne");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnectiion() {
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
			
			PersonDTO person = new PersonDTO();
			person.setId(1);
			person.setName("ASHWINI");
			person.setAddress("PUNE");
			person.setContact(8080943339L);
			person.setDob("07-11-2000");
			
			AadharDTO aadhar = new AadharDTO();
			aadhar.setId(1);
			aadhar.setAadhar_no(123456789012L);
			aadhar.setDoi("01-07-1999");
			
			
			person.setAadhar(aadhar);
			manager.persist(person);
			aadhar.setPerson(person);
			manager.persist(aadhar);

			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnectiion();
		}
	}

}
