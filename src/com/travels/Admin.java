package com.travels;

public class Admin {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String gender;
    private String email;
    private String password;
    private int failedCount;
    private String accountStatus;

    public Admin(String firstName, String lastName, String mobileNumber, String gender, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.failedCount = 0;
        this.accountStatus = "ACTIVE";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    public int getFailedCount() {
        return failedCount;
    }

    public void incrementFailedCount() {
        this.failedCount++;
    }

    public void resetFailedCount() {
        this.failedCount = 0;
    }

    public void lockAccount() {  
        this.accountStatus = "LOCKED";
    }

    public void setAccountStatus(String status) {
        this.accountStatus = status;
    }

    public String getAccountStatus() {
        return accountStatus;
    }
}
