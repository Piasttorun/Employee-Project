package com.sparta.jupiterJazz.Validator;

import com.sparta.jupiterJazz.Employee;

import java.util.Date;

public class EmployeeValidation {

    public static boolean validateEmployee(Employee employee){
        return validateEmployeeID(employee.getEmployeeID()) &&
                validateFirstName(employee.getFirstName()) &&
                validateMiddleInitial(employee.getMiddleInitial()) &&
                validateLastName(employee.getLastName()) &&
                validateGender(employee.getGender()) &&
                validateEmail(employee.getEmail()) &&
                validateDateOfBirth(employee.getDateOfBirth()) &&
                validateDateOfJoining(employee.getDateOfJob()) &&
                validateSalary(employee.getSalary()) &&
                bornBeforeJob(employee.getDateOfBirth(), employee.getDateOfJob()) &&
                datesBeforeToday(employee.getDateOfBirth(), employee.getDateOfJob())
                ;
    }

    private static boolean validateEmployeeID(String employeeID){

        return employeeID.matches("\\d{1,8}");
    }

    private static boolean validateFirstName(String firstName){

        return firstName != null && !firstName.isEmpty();
    }

    private static boolean validateMiddleInitial(char middleInitial){

        return Character.isLetter(middleInitial);
    }

    private static boolean validateLastName(String lastName){

        return lastName != null && !lastName.isEmpty();
    }

    private static boolean validateGender(char gender){

        return gender == 'M' || gender == 'F';
    }

    private static boolean validateEmail(String email){
        return email != null && email.contains("@") && email.contains(".");
    }

    private static boolean validateDateOfBirth(Date dateOfBirth){

        return dateOfBirth != null;
    }

    private static boolean validateDateOfJoining(Date dateOfJoining){

        return dateOfJoining != null;
    }

    private static boolean validateSalary(int salary){

        return salary >0;
    }

    private static boolean bornBeforeJob(Date dateOfBirth, Date dateOfJoin){

        return (dateOfBirth.before(dateOfJoin));
    }

    private static boolean datesBeforeToday(Date dateOfBirth, Date dateOfJoin) {
        Date todaysDate = new Date();
        return (dateOfBirth.before(todaysDate) && dateOfJoin.before(todaysDate));
    }
}
