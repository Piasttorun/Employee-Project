package com.sparta.jupiterJazz;

import java.util.ArrayList;
import java.util.Date;

public class EmployeeDAO {
    @Override
    public Employee searchById(int id) {
        ArrayList<Employee> listOfEmployees = EmployeeDTO.getEmployeeCollection();
    }

    @Override
    public ArrayList<Employee> searchByLastName(String name) {
        return null;
    }

    @Override
    public ArrayList<Employee> searchByDateRange(Date firstDate, Date lastDate) {
        return null;
    }

    @Override
    public ArrayList<Employee> searchByAgeRange(int minAge, int maxAge) {
        return null;
    }
}
