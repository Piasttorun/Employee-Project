package com.sparta.jupiterJazz;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import static com.sparta.jupiterJazz.EmployeeFactory.getEmployees;
import static com.sparta.jupiterJazz.EmployeeMapperUtility.convertStringsToArraylist;

public class EmployeeDTOCreator {


    // Change to a return type of DTO...?
    private static ArrayList<Employee> getEmployeeArraylist(int numEmployees)
            throws IOException, ParseException {
        // Method call to the factory
        String[] employeeStrings = getEmployees(numEmployees);

        // Call the utility class for conversion
        ArrayList<Employee> employeeArrayList = convertStringsToArraylist(employeeStrings);
        return employeeArrayList;

        // Call the validator class to get number of corruptfiles

        // Call DAO and Set DTOs employee arraylist and corruptfiles

        // Might have to instantiate an instance of a DAO. Maybe also an instance of DTO.

    }

    public static void main(String[] args) throws IOException, ParseException {
        getEmployeeArraylist(8);

    }
}
