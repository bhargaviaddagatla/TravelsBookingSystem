package com.travels;

import java.nio.file.Files;
import java.nio.file.Paths;

public class LogoLoader {
    public static void displayLogo() {
        try {
            String logoPath = "C:\\Users\\bharg\\Desktop\\logo.txt"; // Change path accordingly
            String logo = new String(Files.readAllBytes(Paths.get(logoPath)));
            System.out.println(logo);
        } catch (Exception e) {
            System.out.println("Failed to load logo. Proceeding without it...");
        }
    }
}
