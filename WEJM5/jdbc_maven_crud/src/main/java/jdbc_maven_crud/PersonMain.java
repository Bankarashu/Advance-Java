package jdbc_maven_crud;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonMain {
	
	private static Scanner scanner=new Scanner(System.in);	
	private static int choice;
	private static int id;
	private static String name;
	private static long phone;
	
	public static void main(String[] args) {
		try {
			crudOperation();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scanner.close();
	}
	public static void crudOperation() throws ClassNotFoundException, IOException, SQLException {
		
		PersonCRUD crud = new PersonCRUD();
		Person person = new Person();
		boolean flag=true;
		do {
		System.out.println("Operations that U Want to Perform on Person Database..");
		System.out.println("1.Insert \n2.Update \n3.Delete \n4.Display Record \n5.Display All Record \n6.Exit");
		System.out.println("Enter U R Choice:");
		choice = scanner.nextInt();

		
		switch (choice) {
		case 1:
			System.out.println("Enter the ID:");
			 id = scanner.nextInt();
			System.out.println("Enter the name:");
			name = scanner.next();
			System.out.println("Enter the phone No:");
			phone = scanner.nextLong();
						
			person.setId(id);
			person.setName(name);
			person.setPhone(phone);
			crud.savePerson(person);
			break;
			
		case 2:
			System.out.println("Enter the ID:");
			 id = scanner.nextInt();
			System.out.println("Enter the name:");
			 name = scanner.next();
			System.out.println("Enter the phone No:");
			 phone = scanner.nextLong();
			 
			 person.setId(id);
			 person.setName(name);
			 person.setPhone(phone);
			
			crud.updatePerson(person);
			
			break;
			
		case 3:
			System.out.println("Enter the id that U wnat to delete:");
			id = scanner.nextInt();
			
			crud.deletePerson(id);
			break;
			
		case 4:System.out.println("Display the record according to ID:");
		       id=scanner.nextInt();
		       
		       crud.displayRecord(id);  
			break;
			
		case 5:
			crud.displayAllRecord();
			break;

		case 6:
			System.out.println("Thank You.....!!");
			return;
			
		default:
			System.out.println("plz.. Enter correct choice");
			flag=false;
			crudOperation();
			}
		}while(flag);
			
	}
	

}
