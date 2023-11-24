package com.sparta.jupiterJazz;

import com.sparta.jupiterJazz.exceptions.AgeRangeException;
import com.sparta.jupiterJazz.exceptions.DateRangeException;
import com.sparta.jupiterJazz.exceptions.EmployeeIdException;
import com.sparta.jupiterJazz.exceptions.LastNameException;

import java.util.ArrayList;
import java.util.Date;


public class EmployeeDAO implements DAOable {
    public ArrayList<Employee> getEmployees(DTOable DTO) {
        return DTO.getEmployees();
    }

    public void setEmployees(ArrayList<Employee> employees, DTOable DTO) {
        DTO.setEmployees(employees);
    }

    public int getNumCorrupt(DTOable DTO) {
        return DTO.getNumCorrupt();
    }

    public void setNumCorrupt(int numCorrupt, DTOable DTO) {
        DTO.setNumCorrupt(numCorrupt);
    }

    public Employee searchById(String id, DTOable DTO) throws EmployeeIdException {
        Employee result = null;
        for (Employee employee : DTO.getEmployees()) {
            if (employee.getEmployeeID().equals(id)) {
                result = employee;
            }
        }
        if (result == null) {
            throw new EmployeeIdException("Employee ID not found");
        }
        return result;
    }

    public ArrayList<Employee> searchByLastName(String name, DTOable DTO) throws LastNameException {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : DTO.getEmployees()) {
            if (employee.getLastName().toLowerCase().contains(name)) {
                temp.add(employee);
            }
        }
        if (temp.isEmpty()) {
            throw new LastNameException("No employees with matching last name found");
        }
        return temp;
    }

    public ArrayList<Employee> searchByDateRange(Date firstDate, Date lastDate, DTOable DTO) throws DateRangeException {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : DTO.getEmployees()) {
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

    public ArrayList<Employee> searchByAgeRange(Date minDate, Date maxDate, DTOable DTO) throws AgeRangeException {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : DTO.getEmployees()) {
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