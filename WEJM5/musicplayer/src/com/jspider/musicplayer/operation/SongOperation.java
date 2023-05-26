package com.jspider.musicplayer.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jspider.musicplayer.song.Song;

public class SongOperation {
	static List<Song> albumList=new ArrayList<Song>();
	Scanner sc=new Scanner(System.in);
	Song song=new Song();
	private static int choice;
	private static String songEdit;
	private static int songId;
	
	public void playAllSong(){		
		if(albumList.size()==0) {
			System.out.println("No songs are present in Playlist....!! \n");
		}
		else {
		System.out.println("All Songs Are Playing");
		System.out.println(albumList.toString());
		}
	
	}
	
	public void playRandomSong() {
		for(int i=0;i<albumList.size();i++) {
		int randomIndex = (int) (Math.random() * albumList.size());
		System.out.println( "Random Song: " +  albumList.get(randomIndex )+" is now playing" );
		}
	}
	
	public void chooseSong() {
		System.out.println(albumList);
		System.out.println("Choose Song ID To Play");
		int choice=sc.nextInt();
		if(albumList.size()!=0) {
		System.out.println(albumList.get(choice)+" is now playing");
		}
		else {
			System.out.println("No Songs are present in Playlist....!! \n");
			
		}
		
	}
	
	
	public void addSong() {
		Song song = new Song();
		System.out.println("put song id");
		int songid = sc.nextInt();
		song.setId(songid);

		System.out.println("put song name");
		String songName = sc.next();
		song.setName(songName);

		System.out.println("put album name");
		String album = sc.next();
		song.setAlbum(album);

		System.out.println("put singer name");
		String singer = sc.next();
		song.setSinger(singer);

		albumList.add(song);
		

		System.out.println(songName + " successfully added to the list \n");
		System.out.println("----------------------------------------------");		
		
	}
	
	public void removeSong() {
		System.out.println("put song id");
		  choice= sc.nextInt();		 
		  albumList.remove(choice-1);
		  System.out.println();
	}
	
	public void viewAllAong() {
		System.out.println(albumList);
	}
	
	public void editSong() {
		System.out.println("Enter the id of song that u want to edit:");
		songId=sc.nextInt();
	
		if(songId==song.getId()) {
			
			System.out.println("Enter Song Name:");
			songEdit=sc.next();
			song.setName(songEdit);
			 
			System.out.println("Enter Album Name");
			songEdit=sc.next();
			song.setAlbum(songEdit);
			
			System.out.println("Enter Singer Name");
			songEdit=sc.next();
			song.setSinger(songEdit);
					
		
			albumList.set(songId,song);
			System.out.println("Song Successfully Updated...!!!");
			}		
		}

}
