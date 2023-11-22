package com.sparta.jupiterJazz;

import java.util.ArrayList;
import java.util.Date;

public interface DAO {

    ArrayList<Employees> getAllEmployees(DTO dto);

    Employee searchById(int id, DTO dto);

    ArrayList<Employee> searchByLastName(String name, DTO dto);

    ArrayList<Employee> searchByDateRange(Date firstDate, Date lastDate, DTO dto);

    ArrayList<Employee> searchByAgeRange(int minAge, int maxAge, DTO dto);

}
