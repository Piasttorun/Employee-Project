package com.sparta.jupiterJazz.controller;

import com.sparta.jupiterJazz.DAO;
import com.sparta.jupiterJazz.DTO;
import com.sparta.jupiterJazz.EmployeeDAO;
import com.sparta.jupiterJazz.command.AbstractCommand;
import com.sparta.jupiterJazz.command.AbstractCommandFactory;

import java.util.Scanner;

import static com.sparta.jupiterJazz.controller.MainController.chooseSearch;

public class UserInputHandler {

    private static DAO dao = new EmployeeDAO();
    private static DTO dto;
    public static void displayStartMenu(){
        Scanner scanner = new Scanner(System.in);

        int menuInput;
        String employeeID;
        String hireDate;
        String userInput;

        System.out.println("I store your employee data.");
        System.out.println("Please select 1 of the following options: ");
        System.out.println("1. Display my employees");
        System.out.println("2. Search by EmployeeID");
        System.out.println("3. Search by the date they were hired");

        menuInput = scanner.nextInt();
        AbstractCommand command = null;

        switch (menuInput){
            case(1):
                System.out.println("How many employees do you want to display");
                userInput = scanner.next();
                command = AbstractCommandFactory.parseString(menuInput, userInput);
                dto = chooseSearch(command);
                dao.getEmployees(dto);
                break;
            case(2):
                System.out.println("Enter ID");
                userInput = scanner.next();
                command = AbstractCommandFactory.parseString(menuInput, userInput);
                chooseSearch(command);
                break;
            case(3):
                System.out.println("Enter Hire Date Range");
                userInput = scanner.next();
                command = AbstractCommandFactory.parseString(menuInput, userInput);
                chooseSearch(command);
                break;
            case 4:
                System.out.println("Enter age range");
                userInput = scanner.next();
                command = AbstractCommandFactory.parseString(menuInput, userInput);
                chooseSearch(command);
            case 5:
                System.out.println("Enter last name to search: ");
                userInput = scanner.next();
                command = AbstractCommandFactory.parseString(menuInput, userInput);
                chooseSearch(command);
        }
    }

    //ageRange
    //last name
    public static void displayEmployees(int numberOfEmployees){
        //Load(numberOfEmployees)
    }
    public static void findByID(String employID){
        //searchID(employeeID)
    }
    public static void searchHireDate(String hireDate){
        //searchDateRange()
    }

}
