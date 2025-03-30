package com.travels;

import java.time.LocalDate;
import java.util.Scanner;

public class BookingService {
    
    public void bookJourney(Scanner scanner) {
        System.out.println("\n=== Book a Journey ===");
        System.out.print("Enter Source: ");
        String source = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter Travel Date (yyyy-mm-dd): ");
        String dateStr = scanner.nextLine();
        System.out.print("Enter Number of Passengers: ");
        int passengers = Integer.parseInt(scanner.nextLine());

        LocalDate travelDate = LocalDate.parse(dateStr);
        if (!Utility.isValidTravelDate(travelDate)) {
            System.out.println("Invalid travel date. Please select a future date.");
            return;
        }

        double fare = 500.0; // Example base fare
        Journey journey = new Journey(source, destination, travelDate, passengers, fare);
        System.out.println("Booking Confirmed: " + journey);
    }

    public void rescheduleJourney(Scanner scanner, Journey journey) {
        System.out.print("Enter New Travel Date (yyyy-mm-dd): ");
        LocalDate newDate = LocalDate.parse(scanner.nextLine());
        if (!Utility.isValidTravelDate(newDate)) {
            System.out.println("Invalid travel date. Please select a future date.");
            return;
        }
        journey.reschedule(newDate);
    }
}
