package com.company;

public class Employee {
    private final String role;
    private final String name;
    private final String phoneNr;
    private final String email;
    private final String CNP;

    public Employee(String role, String name, String phoneNr, String email, String CNP) {
        this.role=role;
        this.name = name;
        this.phoneNr = phoneNr;
        this.email = email;
        this.CNP = CNP;
    }

    public static Employee createEmployee(String role, String name, String phoneNr, String email, String CNP){
        return new Employee(role,name,phoneNr,email,CNP);
    }

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public String getCNP() {
        return CNP;
    }
}
