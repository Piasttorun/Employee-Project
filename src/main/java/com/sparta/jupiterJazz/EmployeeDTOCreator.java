package com.sparta.jupiterJazz;

import com.sparta.jupiterJazz.Validator.EmployeeValidation;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import static com.sparta.jupiterJazz.EmployeeFactory.getEmployees;
import static com.sparta.jupiterJazz.EmployeeMapperUtility.convertStringsToArraylist;

public class EmployeeDTOCreator {


    // Change to a return type of DTO...?
    public static ArrayList<Employee> getEmployeeArraylist(int numEmployees)
            throws IOException, ParseException {
        // Method call to the factory
        String[] employeeStrings = getEmployees(numEmployees);
        ArrayList<Employee> employeeArrayList = convertStringsToArraylist(employeeStrings);

        //Validates each employee before adding to the list
        ArrayList<Employee> validateEmployees = new ArrayList<>();
        for (Employee employee : employeeArrayList){
            if (EmployeeValidation.validateEmployee(employee)){
                validateEmployees.add(employee);
            }else {
                System.out.println("Invalid employee data: " + employee.toString());
            }
        }

        return validateEmployees;

        // Call the utility class for conversion
//        ArrayList<Employee> employeeArrayList = convertStringsToArraylist(employeeStrings);
//        return employeeArrayList;

        // Call the validator class to get number of corruptfiles

        // Call DAO and Set DTOs employee arraylist and corruptfiles

        // Might have to instantiate an instance of a DAO. Maybe also an instance of DTO.

    }
    
    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<Employee> validateEmployees = getEmployeeArraylist(950);

    }

}
