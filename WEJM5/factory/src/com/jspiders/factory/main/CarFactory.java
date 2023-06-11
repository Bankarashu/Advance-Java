package com.jspiders.factory.main;

import java.util.Scanner;

import com.jspiders.factory.cars.Endevour;
import com.jspiders.factory.cars.Harrier;
import com.jspiders.factory.cars.HondaCity;
import com.jspiders.factory.cars.Nexon;
import com.jspiders.factory.cars.SUV100;
import com.jspiders.factory.inter.Car;

public class CarFactory {
	private static Car car;

	public static void main(String[] args) {
		factory().buyCar();

	}

	public static Car factory() {

		System.out.println("Car Purchase Option \n" + "1.Harrier \n" + "2.Honda City \n" + "3.SUV100 \n"
				+ "4.Endevour \n" + "5.Nexon \n");

		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		scanner.close();
		switch (choice) {
		case 1:
			car = new Harrier();
			break;

		case 2:
			car = new HondaCity();
			break;

		case 3:
			car = new SUV100();
			break;

		case 4:
			car = new Endevour();
			break;

		case 5:
			car = new Nexon();
			break;

		default:
			System.out.println("Invalid choice");
			break;
		}

		return car;

	}

}
