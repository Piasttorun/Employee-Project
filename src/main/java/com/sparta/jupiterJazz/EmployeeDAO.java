package com.sparta.jupiterJazz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class EmployeeDAO implements DAO {

    public static ArrayList<Employees> getAllEmployees(DTO dto) {
        return dto.getAllEmplyees();
    }

    //May throw new employeeIdException
    public static Employee searchById(int id, DTO dto) {
        Employee result = null;
        for (Employee employee: dto.getAllEmployees) {
            if (Employee.getId == id) {
                result = employee;
            }
        }
        return result;
    }

    public static ArrayList<Employee> searchByLastName(String name, DTO dto) {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : dto.getAllEmployees()) {
            if (employee.getLastName().contains(name)) {
                temp.add(employee);
            }
        }
        return temp;
    }

    public static ArrayList<Employee> searchByDateRange(SimpleDateFormat firstDate, SimpleDateFormat lastDate, DTO dto) {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee: dto.getAllEmployees()) {
            if (employee.getDate().after(firstDate) && employee.getDate().before(lastDate)) {
                temp.add(employee);
            }
        }
        return temp;
    }

    public static ArrayList<Employee> searchByAgeRange(int minAge, int maxAge, DTO dto) {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : dto.getAllEmployees()) {
            if (employee.getAge() >= minAge && employee.getAge() <= maxAge) {
                temp.add(employee);
            }
        }
        return temp;
    }
}
