package com.sparta.jupiterJazz;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public interface DAO {

    ArrayList<Employee> getEmployees(DTO dto);

    Employee searchById(String id, DTO dto);

    ArrayList<Employee> searchByLastName(String name, DTO dto);

    ArrayList<Employee> searchByDateRange(Date firstDate, Date lastDate, DTO dto);
    ArrayList<Employee> searchByAgeRange(Date minDate, Date maxDate, DTO dto);

    void setEmployees(ArrayList<Employee> employees, DTO dto);

    int getNumCorrupt(DTO dto);

    void setNumCorrupt(int numCorrupt, DTO dto);


}
