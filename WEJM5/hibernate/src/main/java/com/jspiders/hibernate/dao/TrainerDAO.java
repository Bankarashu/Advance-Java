package com.jspiders.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernate.dto.TrainerDTO;

public class TrainerDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static String jpql1;
	private static javax.persistence.Query query;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("jpql");
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

			TrainerDTO trainerDTO = new TrainerDTO();
			trainerDTO.setName("ROSHANI");
			trainerDTO.setEmail("roshani@gmail.com");
			trainerDTO.setSubject("Core Java");
			manager.persist(trainerDTO);

			TrainerDTO trainerDTO1 = new TrainerDTO();
			trainerDTO1.setName("Ashwini");
			trainerDTO1.setEmail("ashwini@gmail.com");
			trainerDTO1.setSubject("Advance java");
			manager.persist(trainerDTO1);

			jpql1 = "from TrainerDTO";
			query = manager.createQuery(jpql1);

			List<TrainerDTO> trainers = query.getResultList();
			for (TrainerDTO trainerDTO3 : trainers) {
				System.out.println(trainerDTO3);

			}

			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

}
