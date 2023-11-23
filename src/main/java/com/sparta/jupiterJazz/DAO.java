package com.sparta.jupiterJazz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public interface DAO {

    ArrayList<Employee> getEmployees(DTO dto);

    Employee searchById(String id, DTO dto);

    ArrayList<Employee> searchByLastName(String name, DTO dto);

    public ArrayList<Employee> searchByDateRange(Date firstDate, Date lastDate, DTO dto);
    public ArrayList<Employee> searchByAgeRange(Date minDate, Date maxDate, DTO dto);

}
