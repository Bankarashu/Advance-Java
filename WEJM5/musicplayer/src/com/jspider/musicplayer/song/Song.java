package com.jspider.musicplayer.song;

import java.util.Scanner;


public class Song {
	static Scanner sc=new Scanner(System.in);
	private int id;
	private String name;
	private String album;
	private String singer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return name+"\n";
	}
		
}

	
	

