package com.jspiders.filehandling.filedelete;

import java.io.File;

public class FileDelete {
	public static void main(String[] args) {
		File file = new File("wejm5sample.txt");
		
		if(file.exists()) {
			file.delete();
			System.out.println("File Deleted Successfully...");
		}else {
			System.out.println("File Does Not Exists...");
		}
	}

}
