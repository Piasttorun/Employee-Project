package com.sparta.jupiterJazz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public interface DAO {

    ArrayList<Employees> getAllEmployees(DTO dto);

    Employee searchById(int id, DTO dto);

    ArrayList<Employee> searchByLastName(String name, DTO dto);

    ArrayList<Employee> searchByDateRange(SimpleDateFormat firstDate, SimpleDateFormat lastDate, DTO dto);

    ArrayList<Employee> searchByAgeRange(int minAge, int maxAge, DTO dto);

}
