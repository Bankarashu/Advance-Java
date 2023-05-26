package jdbc_crud_task;

import java.util.Scanner;

public class UserMain {
	private static Scanner scanner = new Scanner(System.in);
	private static int choice;

	public static void main(String[] args) throws Exception {
		userOperation();
		scanner.close();
	}

	public static void userOperation() throws Exception {
		UserCRUDOperation crudOperation = new UserCRUDOperation();
		User user = new User();
		boolean flag = true;
		do {
			System.out.println("Enter the Choice: \n1.SighUp \n2.Login \n3.Display \n4.Exit");
			choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Enter the id:");
				user.setId(scanner.nextInt());
				System.out.println("Enter the name:");
				user.setName(scanner.next());
				System.out.println("Enter email");
				user.setEmail(scanner.next());
				System.out.println("Enter the password:");
				user.setPassword(scanner.next());
				System.out.println("Enter the address:");
				user.setAddress(scanner.next());

				crudOperation.signUp(user);

			}
				break;

			case 2: {
				System.out.println("Enter the email:");
				String email = scanner.next();
				user.setEmail(email);

				System.out.println("Enter the password:");
				user.setPassword(scanner.next());

				boolean result = crudOperation.logIn(user);
				if (result) {
					System.out.println("\nLogin Successfully..\n");
					crudOperation.displayPasswords(email);
					boolean condition = true;
					do {
						System.out.println("Enter the Choice \n1.Update Passwords \n2.Logout");
						int choice = scanner.nextInt();
						
						switch (choice) {
						case 1:{
							System.out.println("Enter Facebook Password:");
							String facebook = scanner.next();
							System.out.println("Enetr What's up Password:");
							String whatsup = scanner.next();
							System.out.println("Enter Sanp Chat Password:");
							String snapchat = scanner.next();
							System.out.println("Enter Twitter Password:");
							String twitter = scanner.next();
									
							user.setFacebookpassword(facebook);
							user.setWhatsuppassword(whatsup);
							user.setSnappassword(snapchat);
							user.setTwitterpassword(twitter);
							
							crudOperation.updatePassword(user);
						}
							
							break;

						default:
							condition = false;
						}
					} while (condition);
					
				} else {
					System.out.println("\n Fail to Login \n");
				}

			}
				break;

			case 3: {
				crudOperation.displayRecord();
			}
				break;
			case 4: {
				System.out.println("Thank You.....!!");
				return;
			}

			default:
				System.out.println("plz.. Enter correct choice");
				flag = false;
				break;
			}
		} while (flag);
	}
}
