package com.sparta.jupiterJazz;

import com.sparta.jupiterJazz.exceptions.AgeRangeException;
import com.sparta.jupiterJazz.exceptions.DateRangeException;
import com.sparta.jupiterJazz.exceptions.EmployeeIdException;
import com.sparta.jupiterJazz.exceptions.LastNameException;

import java.util.ArrayList;
import java.util.Date;


public class EmployeeDAOable implements DAOable {
    public ArrayList<Employee> getEmployees(DTOable DTOable) {
        return DTOable.getEmployees();
    }

    public void setEmployees(ArrayList<Employee> employees, DTOable DTOable) {
        DTOable.setEmployees(employees);
    }

    public int getNumCorrupt(DTOable DTOable) { return DTOable.getNumCorrupt(); }

    public void setNumCorrupt(int numCorrupt, DTOable DTOable) {
        DTOable.setNumCorrupt(numCorrupt);
    }

    public EmployeeDAOable(){}
    public Employee searchById(String id, DTOable DTOable) throws EmployeeIdException {
        Employee result = null;
        for (Employee employee : DTOable.getEmployees()) {
            if (employee.getEmployeeID().equals(id)) {
                result = employee;
            }
        }
        if (result == null) {
            throw new EmployeeIdException("Employee ID not found");
        }
        return result;
    }

    public ArrayList<Employee> searchByLastName(String name, DTOable DTOable) throws LastNameException {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : DTOable.getEmployees()) {
            if (employee.getLastName().toLowerCase().contains(name)) {
                temp.add(employee);
            }
        }
        if (temp.isEmpty()) {
            throw new LastNameException("No employees with matching last name found");
        }
        return temp;
    }

    public ArrayList<Employee> searchByDateRange(Date firstDate, Date lastDate, DTOable DTOable) throws DateRangeException {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : DTOable.getEmployees()) {
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

    public ArrayList<Employee> searchByAgeRange(Date minDate, Date maxDate, DTOable DTOable) throws AgeRangeException {
        ArrayList<Employee> temp = new ArrayList<>();
        for (Employee employee : DTOable.getEmployees()) {
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