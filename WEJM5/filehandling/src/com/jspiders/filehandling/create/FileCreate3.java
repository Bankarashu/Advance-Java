package com.jspiders.filehandling.create;

import java.io.File;
import java.io.IOException;

public class FileCreate3 {
	public static void main(String[] args) {
		File file = new File("F:\\Programs\\wejm5.txt");
		
		try {
			file.createNewFile();
			System.out.println("File created successully..");
		} catch (IOException e) {
			System.out.println("File not created..");
		}
	}

}
