package com.jspiders.hibernate_musicplayer.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.hibernate_musicplayer.dto.MusicPlayerDTO;

public class MusicPlayerDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Scanner scanner = new Scanner(System.in);
	private static int choice;
	private static char ch;
	private static MusicPlayerDTO dto = new MusicPlayerDTO();
	private static Query query;
	private static String jpql;
	private static int id;

	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("musicplayer");
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
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		musicPlayerMenu();
		scanner.close();

	}

	public static void musicPlayerMenu() throws Exception {
		System.out.println("-------- MENU --------");
		System.out.println("1.Play Song \n2.Add/Remove Song \n3.Edit Song \n4.Exit");
		System.out.println("Enter the Choice");
		choice = scanner.nextInt();

		switch (choice) {
		case 1:
			do {
				System.out.println("******** Play All Songs Menu ********");
				System.out.println("1.Play All Song \n2.Play Random Song \n3.Choose to Play \n4.Go Back");
				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					playAllSong();
					break;
				case 2:
					// playRandomSong();
					break;
				case 3:
					System.out.println("Play the song according to ID:");
					id = scanner.nextInt();
					chooseSong(id);
					break;
				case 4:
					musicPlayerMenu();
					break;
				default:
					System.out.println("Plz Enter Correct Choice....");
					break;
				}
				System.out.println("Do U have another choice ? y/n:\n");
				ch = scanner.next().charAt(0);
			} while (ch != 'n');
			musicPlayerMenu();
			return;
		case 2:
			do {
				System.out.println("======== Add/Remove Songs Menu ========");
				System.out.println("1.Add Song \n2.Remove Song \n3.Go Back");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:

					System.out.println("Enter the id:");
					dto.setId(scanner.nextInt());
					System.out.println("Enter the name");
					dto.setName(scanner.next());
					System.out.println("Enter the album");
					dto.setAblum(scanner.next());
					System.out.println("Enter the singer");
					dto.setSinger(scanner.next());
					addSong(dto);
					break;

				case 2:
					System.out.println("Enter the id that U want to delete song:");
					id = scanner.nextInt();
					removeSong(id);
					break;
				case 3:
					musicPlayerMenu();
					break;
				default:
					System.out.println("Plz Enter Correct Choice....");
					break;
				}
				System.out.println("Do U have another choice ? y/n:\n");
				ch = scanner.next().charAt(0);
			} while (ch != 'n');
			musicPlayerMenu();
			return;
		case 3:
			System.out.println("Enter the id that U want to update song:");
			id = scanner.nextInt();
			editSong(id);
			musicPlayerMenu();
			break;
		case 4:
			System.out.println("Thank You.....!!");
			break;

		default:
			System.out.println("\n Plz Enter Correct Choice...\n");
			musicPlayerMenu();
		}
	}

	private static void editSong(int id2) {
		openConnection();
		transaction.begin();
		dto = manager.find(MusicPlayerDTO.class, id2);
		if(dto != null) {
		System.out.println("Enter the name");
		dto.setName(scanner.next());
		System.out.println("Enter the album");
		dto.setAblum(scanner.next());
		System.out.println("Enter the singer");
		dto.setSinger(scanner.next());
		}
		transaction.commit();
		closeConnection();
		
	}

	private static void removeSong(int id2) {
		openConnection();
		transaction.begin();
		dto = manager.find(MusicPlayerDTO.class, id2);
		manager.remove(dto);

		transaction.commit();
		closeConnection();

	}

	private static void chooseSong(int id2) {
		openConnection();
		transaction.begin();
		dto = manager.find(MusicPlayerDTO.class, id2);
		System.out.println(dto);
		transaction.commit();
		closeConnection();

	}

	private static void playAllSong() {
		openConnection();
		transaction.begin();
		jpql = "from MusicPlayerDTO";
		query = manager.createQuery(jpql);

		@SuppressWarnings("unchecked")
		List<MusicPlayerDTO> music = query.getResultList();
		for (MusicPlayerDTO song : music) {
			System.out.println(song);

		}

		transaction.commit();
		closeConnection();

	}

	private static void addSong(MusicPlayerDTO dto) {
		openConnection();
		transaction.begin();

		manager.persist(dto);

		manager.persist(dto);

		transaction.commit();
		closeConnection();

	}
}
