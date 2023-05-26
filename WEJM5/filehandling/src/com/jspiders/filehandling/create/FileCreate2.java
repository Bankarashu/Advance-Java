package com.jspiders.filehandling.create;

import java.io.File;
import java.io.IOException;

public class FileCreate2 {
	public static void main(String[] args) {
		File file = new File("F:\\Programs\\WEJM5\\files\\wejm3.pwt");
		
		if(file.exists()) {
			System.out.println("File already exists...!!!");
		}else {
			try {
				file.createNewFile();
				System.out.println("File created successfully...!!!");
			} catch (IOException e) {
				System.out.println("File no created...!!!");
			}
		}
	}

}
