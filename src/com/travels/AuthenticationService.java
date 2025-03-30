package com.travels;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthenticationService {
    private Map<String, Admin> adminUsers = new HashMap<>();

    public void registerAdmin(Scanner scanner) {
        System.out.println("\n=== Admin Registration ===");
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Mobile Number: ");
        String mobile = scanner.nextLine();
        System.out.print("Enter Gender (M/F): ");
        String gender = scanner.nextLine();
        System.out.print("Enter Email ID: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Admin newAdmin = new Admin(firstName, lastName, mobile, gender, email, password);
        adminUsers.put(email, newAdmin);
        System.out.println("Admin Registered Successfully!");
    }

    public boolean login(Scanner scanner) {
        System.out.println("\n=== Admin Login ===");
        System.out.print("Enter Email ID: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (adminUsers.containsKey(email)) {
            Admin admin = adminUsers.get(email);
            if (admin.getAccountStatus().equals("LOCKED")) {
                System.out.println("Account is LOCKED due to multiple failed attempts!");
                return false;
            }
            if (admin.getPassword().equals(password)) {
                admin.resetFailedCount();
                System.out.println("Login Successful!");
                return true;
            } else {
                admin.incrementFailedCount();
                if (admin.getFailedCount() >= 5) {
                    admin.lockAccount();
                    System.out.println("Too many failed attempts! Account is now LOCKED.");
                } else {
                    System.out.println("Incorrect Password! Attempts left: " + (5 - admin.getFailedCount()));
                }
            }
        } else {
            System.out.println("No such user found. Please register first.");
        }
        return false;
    }
}
