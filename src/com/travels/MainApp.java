package com.travels;

import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AuthenticationService authService = new AuthenticationService();
		BookingService bookingService = new BookingService();

		LogoLoader.displayLogo();

		while (true) {
			System.out.println("\n=== Travels and Logistics System ===");
			System.out.println("1. Register Admin");
			System.out.println("2. Login Admin");
			System.out.println("3. Book Journey");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				authService.registerAdmin(scanner);
				break;
			case 2:
				if (authService.login(scanner)) {
					System.out.println("Admin Logged In Successfully.");
				}
				break;
			case 3:
				bookingService.bookJourney(scanner);
				break;
			case 4:
				System.out.println("Exiting Application. Have a nice day!");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice! Please enter again.");
			}
		}
	}
}
