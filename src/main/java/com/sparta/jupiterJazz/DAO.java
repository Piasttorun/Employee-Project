package com.sparta.jupiterJazz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public interface DAO {

    static ArrayList<Employee> getAllEmployees(DTO dto);

    static Employee searchById(int id, DTO dto);

    static ArrayList<Employee> searchByLastName(String name, DTO dto);

    static ArrayList<Employee> searchByDateRange(SimpleDateFormat firstDate, SimpleDateFormat lastDate, DTO dto);

    static ArrayList<Employee> searchByAgeRange(int minAge, int maxAge, DTO dto);

}
