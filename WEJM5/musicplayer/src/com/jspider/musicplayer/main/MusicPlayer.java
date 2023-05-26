package com.jspider.musicplayer.main;
import java.util.Scanner;
import com.jspider.musicplayer.operation.SongOperation;

public class MusicPlayer {
	private static Scanner sc=new Scanner(System.in);	
	private static int choice;
	private static char ch;
	
	public static void main(String[] args) {
		
		musicPlayerMenu();
		sc.close();
		
	}
	public static void musicPlayerMenu() {
		System.out.println("-------- MENU --------");
		System.out.println("1.Play Song \n2.Add/Remove Song \n3.Edit Song \n4.Exit");
		System.out.println("Enter the Choice");
		choice=sc.nextInt();
		
		switch(choice){
		case 1:
			do {
				System.out.println("******** Play All Songs Menu ********");
			System.out.println("1.Play All Song \n2.Play Random Song \n3.Choose to Play \n4.Go Back");
			choice=sc.nextInt();
			SongOperation so=new SongOperation();
			
			switch(choice) {
			case 1:
				so.playAllSong();
				break;
			case 2:
				so.playRandomSong();
				break;
			case 3:
				so.chooseSong();
				break;
			case 4:
				musicPlayerMenu();
				break;
			default:
				System.out.println("Plz Enter Correct Choice....");
				break;
				}
				System.out.println("Do U have another choice ? y/n:\n");
				ch=sc.next().charAt(0);
			}while(ch!='n');
			musicPlayerMenu();
			return;
			
		case 2:
			do {
			System.out.println("======== Add/Remove Songs Menu ========");
			System.out.println("1.Add Song \n2.Remove Song \n3.Go Back");
			choice=sc.nextInt();
			SongOperation songoperation=new SongOperation();
				switch(choice) {
				case 1:
					songoperation.addSong();
					break;
				case 2:
					songoperation.removeSong();
					break;
				case 3:
					musicPlayerMenu();
					break;
				default:
					System.out.println("Plz Enter Correct Choice....");
					break;
				}
				System.out.println("Do U have another choice ? y/n:\n");
				ch=sc.next().charAt(0);
			}while(ch!='n');
			musicPlayerMenu();
			return;
		case 3:
			SongOperation songlist=new SongOperation();
			songlist.viewAllAong();
			songlist.editSong();
			musicPlayerMenu();
			break;
		case 4:
			System.out.println("Thank You.....!!");
			return;
			
		default:
			System.out.println("\n Plz Enter Correct Choice...\n");
			musicPlayerMenu();
		}
		
	}

}
