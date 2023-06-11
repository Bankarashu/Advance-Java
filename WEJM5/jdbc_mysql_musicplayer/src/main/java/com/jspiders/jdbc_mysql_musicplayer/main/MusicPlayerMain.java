package com.jspiders.jdbc_mysql_musicplayer.main;

import java.util.Scanner;

import com.jspiders.jdbc_mysql_musicplayer.song.Song;
import com.jspiders.jdbc_mysql_musicplayer.songoperations.SongOperations;

public class MusicPlayerMain {
	private static Scanner scanner = new Scanner(System.in);
	private static int choice;
	private static char ch;
	private static int id;

	public static void main(String[] args) throws Exception {

		musicPlayerMenu();
		scanner.close();

	}

	public static void musicPlayerMenu() throws Exception {
		Song song = new Song();
		SongOperations songoperation = new SongOperations();
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
					songoperation.playAllSong();
					break;
				case 2:

//					songoperation.playRandomSong();
					break;
				case 3:
					System.out.println("Play the song according to ID:");
					id = scanner.nextInt();
					songoperation.chooseSong(id);
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
					song.setId(scanner.nextInt());
					System.out.println("Enter the name:");
					song.setName(scanner.next());
					System.out.println("Enter album");
					song.setAlbum(scanner.next());
					System.out.println("Enter the singer:");
					song.setSinger(scanner.next());

					songoperation.addSong(song);
					break;
				case 2:
					System.out.println("Enter the id that U want to delete song:");
					id = scanner.nextInt();
					songoperation.removeSong(id);
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
			break;
		case 3:
			System.out.println("Enter the id:");
			song.setId(scanner.nextInt());
			System.out.println("Enter the name:");
			song.setName(scanner.next());
			System.out.println("Enter album");
			song.setAlbum(scanner.next());
			System.out.println("Enter the singer:");
			song.setSinger(scanner.next());

			songoperation.editSong(song);
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

}
