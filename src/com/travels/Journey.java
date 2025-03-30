package com.travels;

import java.time.LocalDate;

public class Journey {
    private String source;
    private String destination;
    private LocalDate travelDate;
    private int passengers;
    private double fare;

    public Journey(String source, String destination, LocalDate travelDate, int passengers, double fare) {
        this.source = source;
        this.destination = destination;
        this.travelDate = travelDate;
        this.passengers = passengers;
        this.fare = fare;
    }

    public double calculateTotalFare() {
        double totalFare = fare * passengers;
        if (Utility.isWeekend(travelDate)) {
            totalFare += 200 * passengers;
        }
        double gst = totalFare * 0.18; // 18% GST
        return totalFare + gst;
    }

    public void reschedule(LocalDate newDate) {
        this.travelDate = newDate;
        System.out.println("Travel date successfully updated to " + newDate);
    }

    @Override
    public String toString() {
        return "Journey from " + source + " to " + destination + " on " + travelDate +
                " for " + passengers + " passengers. Estimated Fare: " + calculateTotalFare();
    }
}

