package com.travels;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class Utility {

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return Pattern.matches(emailRegex, email);
    }

    public static boolean isValidMobile(String mobile) {
        String mobileRegex = "^[6-9]\\d{9}$"; // Indian mobile number format
        return Pattern.matches(mobileRegex, mobile);
    }

    public static boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    public static boolean isValidTravelDate(LocalDate date) {
        return !date.isBefore(LocalDate.now());
    }
}

