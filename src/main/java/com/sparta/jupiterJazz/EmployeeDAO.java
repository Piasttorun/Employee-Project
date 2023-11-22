package com.sparta.jupiterJazz;

import java.util.ArrayList;
import java.util.Date;

public class EmployeeDAO implements DAO{
    @Override
    public static <Employees> getAllEmployees() {

    }

    @Override
    public static searchById(int id) {
        ArrayList<Employee> listOfEmployees = EmployeeDTO.getEmployeeCollection();
    }

    @Override
    public static <Employee> searchByLastName(String name) {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : dto.getAllEmployees()) {
            if (employee.getLastName().contains(name)) {
                temp.add(employee);
            }
        }
        return temp;
    }

    @Override
    public static <Employee> searchByDateRange(Date firstDate, Date lastDate) {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : dto.getAllEmployees()) {
            if (employee.getAge() >= minAge && employee.getAge() <= maxAge) {
                temp.add(employee);
            }
        }
        return temp;
    }

    @Override
    public static <Employee> searchByAgeRange(int minAge, int maxAge) {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : dto.getAllEmployees()) {
            if (employee.getAge() >= minAge && employee.getAge() <= maxAge) {
                temp.add(employee);
            }
        }
        return temp;
    }
}
