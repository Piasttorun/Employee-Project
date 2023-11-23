package com.sparta.jupiterJazz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeMapperUtility {

    public static ArrayList<Employee> convertStringsToArraylist(String[] employeeStrings)
            throws ParseException {
        ArrayList<Employee> employeeArrayList = new ArrayList<>();

        for (String employeeString: employeeStrings) {
            employeeArrayList.add(convertStringToEmployee(employeeString));
        }

        return employeeArrayList;
    }

    private static Employee convertStringToEmployee(String employeeString) throws ParseException {
        String[] eFields = employeeString.split(",");

        for (String fieldstring: eFields) {
            System.out.print(fieldstring);
        }

        return new Employee(eFields[0], eFields[1], eFields[2],
                toChar(eFields[3]), eFields[4], toChar(eFields[5]), eFields[6],
                toDate(eFields[7]), toDate(eFields[8]) , toInt(eFields[9]));

    }

    private static int toInt(String inputString) {
        return Integer.parseInt(inputString);
    }

    private static char toChar(String inputString) {
        return inputString.charAt(0);
    }

    private static Date toDate(String inputString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        return dateFormat.parse(inputString);
    }



}
