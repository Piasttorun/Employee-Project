package com.sparta.jupiterJazz.controller;

import com.sparta.jupiterJazz.DAO;
import com.sparta.jupiterJazz.DTO;
import com.sparta.jupiterJazz.EmployeeDAO;
import com.sparta.jupiterJazz.Validator.userInputValidator;
import com.sparta.jupiterJazz.command.AbstractCommand;
import com.sparta.jupiterJazz.command.AbstractCommandFactory;

import java.util.Scanner;

import static com.sparta.jupiterJazz.controller.MainController.chooseSearch;

public class UserInputHandler {

    private static DAO dao = new EmployeeDAO();
    private static DTO dto;
    private static Scanner scanner = new Scanner(System.in);
    public static void displayStartMenu(){

        int menuInput;
        String employeeID;
        String hireDate;
        String userInput;

        System.out.println("I store your employee data.");
        System.out.println("Please select 1 of the following options: ");
        System.out.println("1. Display my employees");
        System.out.println("2. Search by EmployeeID");
        System.out.println("3. Search by the date they were hired");
        System.out.println("4. Search by age range");
        System.out.println("5. Search by last name");

        menuInput = scanner.nextInt();
        AbstractCommand command = null;

        switch (menuInput){
            case(1):
                System.out.println("How many employees do you want to display");
                userInput = scanner.next();
                while (!userInputValidator.validateNumEmployees(userInput)) {
                    System.out.println("Invalid entry, number must be between 1 and 1000, please try again");
                    userInput = scanner.next();
                }
                command = AbstractCommandFactory.parseString(menuInput, userInput);
                dto = chooseSearch(command);
                dao.getEmployees(dto);
                break;
            case(2):
                System.out.println("Enter ID");
                userInput = scanner.next();
                while (!userInputValidator.validateEmployeeID(userInput)) {
                    System.out.println("Invalid ID, must be a maximum of 8 digits, please try again");
                    userInput = scanner.next();
                }
                command = AbstractCommandFactory.parseString(menuInput, userInput);
                chooseSearch(command);
                break;
            case(3):
                userInput = searchByHiredDate();
                command = AbstractCommandFactory.parseString(menuInput, userInput);
                chooseSearch(command);
                break;
            case 4:
                userInput = searchByAgeRange();
                command = AbstractCommandFactory.parseString(menuInput, userInput);
                chooseSearch(command);
                break;
            case 5:
                System.out.println("Enter last name to search: ");
                userInput = scanner.next();
                while (!userInputValidator.validateNameInput(userInput)) {
                    System.out.println("Invalid name input, name can only contain letters, please try again");
                    userInput = scanner.next();
                }
                command = AbstractCommandFactory.parseString(menuInput, userInput);
                chooseSearch(command);
        }
    }

    private static String searchByHiredDate() {
            System.out.println("Enter First Date Of Range");
            System.out.println("Enter in format: YYYY/MM/DD");
            String firstDateInput = scanner.next();
            System.out.println("Enter Second Date Of Range");
            System.out.println("Enter in format: YYYY/MM/DD");
            String secondDateInput = scanner.next();
            if (!userInputValidator.validateDates(firstDateInput, secondDateInput)) {
                System.out.println("Invalid dates, both dates must be in format YYYY/MM/DD, please try again");
                searchByHiredDate();
            }
        return firstDateInput + " " + secondDateInput;
    }

    private static String searchByAgeRange() {
        System.out.println("Enter first age");
        String firstAge = scanner.next();
        System.out.println("Enter second age");
        String secondAge = scanner.next();
        if (!userInputValidator.validateAgeInput(firstAge, secondAge)) {
            System.out.println("Invalid age input, ages must be digits and between 1 and 99, please try again");
            searchByAgeRange();
        }
        return firstAge + " " + secondAge;
    }
}
