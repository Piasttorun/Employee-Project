package com.sparta.jupiterJazz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class EmployeeDAO implements DAO {
    public ArrayList<Employee> getEmployees(DTO dto) {
        return dto.getEmployees();
    }

    //May throw new employeeIdException
    public Employee searchById(String id, DTO dto) {
        Employee result = null;
        for (Employee employee: dto.getEmployees()) {
            if (employee.getEmployeeID() == id) {
                result = employee;
            }
        }
        return result;
    }

    public ArrayList<Employee> searchByLastName(String name, DTO dto) {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : dto.getEmployees()) {
            if (employee.getLastName().contains(name)) {
                temp.add(employee);
            }
        }
        return temp;
    }

    public ArrayList<Employee> searchByDateRange(Date firstDate, Date lastDate, DTO dto) {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee: dto.getEmployees()) {
            if (employee.getDateOfJob().after(firstDate) &&
                    employee.getDateOfJob().before(lastDate)) {
                temp.add(employee);
            }
        }
        return temp;
    }

    public ArrayList<Employee> searchByAgeRange(Date minDate, Date maxDate, DTO dto) {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : dto.getEmployees()) {
            if (employee.getDateOfBirth().after(minDate) &&
                    employee.getDateOfBirth().before(minDate)) {
                temp.add(employee);
            }
        }
        return temp;
    }
}
