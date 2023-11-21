package com.sparta.jupiterJazz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class EmployeeDTO {

//    private int employeeID;
//    private String prefix;
//    private String firstName;
//    private char middleInitial;
//    private char gender;
//    private String email;
//    private Date dateOfBirth;
//    private Date dateOfJob;
//    private int salary;

    private HashMap<Integer, Employee> employees;
    private int numCorrupt;

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        HashMap<Integer,Employee> employeeHashMap;
        for (Employee employee: employees) {
            employeeHashMap.put(employee.getID(), employee);
        }
        this.employees = employees;
    }

    public void setNumCorrupt(int numCorrupt) {
        this.numCorrupt = numCorrupt;
    }

    public static HashMap getEmployees(int numEmployees) {
    }

    public static int getNumCorrupt() {

    }
}
