package com.sparta.jupiterJazz;

import com.sparta.jupiterJazz.exceptions.AgeRangeException;
import com.sparta.jupiterJazz.exceptions.DateRangeException;
import com.sparta.jupiterJazz.exceptions.EmployeeIdException;
import com.sparta.jupiterJazz.exceptions.LastNameException;

import java.util.ArrayList;
import java.util.Date;


public class EmployeeDAO implements DAO {
    public ArrayList<Employee> getEmployees(DTO dto) {
        return dto.getEmployees();
    }

    public void setEmployees(ArrayList<Employee> employees, DTO dto) {
        dto.setEmployees(employees);
    }

    public int getNumCorrupt(DTO dto) { return dto.getNumCorrupt(); }

    public void setNumCorrupt(int numCorrupt, DTO dto) {
        dto.setNumCorrupt(numCorrupt);
    }

    public EmployeeDAO(){}
    public Employee searchById(String id, DTO dto) throws EmployeeIdException {
        Employee result = null;
        for (Employee employee : dto.getEmployees()) {
            if (employee.getEmployeeID().equals(id)) {
                result = employee;
            }
        }
        if (result == null) {
            throw new EmployeeIdException("Employee ID not found");
        }
        return result;
    }

    public ArrayList<Employee> searchByLastName(String name, DTO dto) throws LastNameException {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : dto.getEmployees()) {
            if (employee.getLastName().contains(name)) {
                temp.add(employee);
            }
        }
        if (temp.isEmpty()) {
            throw new LastNameException("No employees with matching last name found");
        }
        return temp;
    }

    public ArrayList<Employee> searchByDateRange(Date firstDate, Date lastDate, DTO dto) throws DateRangeException {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : dto.getEmployees()) {
            if (employee.getDateOfJob().after(firstDate) &&
                    employee.getDateOfJob().before(lastDate)) {
                temp.add(employee);
            }
        }
        if (temp.isEmpty()) {
            throw new DateRangeException("No employees found within given date range");
        }
        return temp;
    }

    public ArrayList<Employee> searchByAgeRange(Date minDate, Date maxDate, DTO dto) throws AgeRangeException {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : dto.getEmployees()) {
            if (employee.getDateOfBirth().after(minDate) &&
                    employee.getDateOfBirth().before(maxDate)) {
                temp.add(employee);
            }
        }
        if (temp.isEmpty()) {
            throw new AgeRangeException("No employees found within given age range");
        }
        return temp;
    }
}