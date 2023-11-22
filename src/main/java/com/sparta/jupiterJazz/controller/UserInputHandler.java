package com.sparta.jupiterJazz.controller;

import java.util.Scanner;

public class UserInputHandler {

    public static void displayStartMenu(){
        Scanner scanner = new Scanner(System.in);

        int menuInput;
        String employeeID;
        String hireDate;

        System.out.println("I store your employee data.");
        System.out.println("Please select 1 of the following options: ");
        System.out.println("1. Display my employees");
        System.out.println("2. Search by EmployeeID");
        System.out.println("3. Search by the date they were hired");

        menuInput = scanner.nextInt();

        switch (menuInput){
            case(1):
                System.out.println("How many employees do you want to display");
                menuInput=scanner.nextInt();
                displayEmployees(menuInput);
                break;
            case(2):
                System.out.println("Enter ID");
                employeeID = scanner.next();
                findByID(employeeID);
                break;
            case(3):
                System.out.println("Enter HireDate");
                hireDate = scanner.next();
                searchHireDate(hireDate);
                break;
        }
    }

    public static void displayEmployees(int numberOfEmployees){
        //Load(numberOfEmployees)
    }
    public static void findByID(String employID){
        //searchID(employeeID)
    }
    public static void searchHireDate(String hireDate){
        //searchDateRange
    }

}
