package com.jspiders.filehandling.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteWrite {
	public static void main(String[] args) {
		File file = new File("Byte.txt");
		if(file.exists()) {
			System.out.println("File already exists..!!");
		}else {
			try {
				file.createNewFile();
				System.out.println("File created successfully..!!");
			} catch (IOException e) {
				System.out.println("File not created..!!");
			}
		}
		
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(50);
			System.out.println("Data write to file..!!");
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found..!!");
		} catch (IOException e) {
			System.out.println("Unable to write data..!!");
		}
			
		
	}

}
