package com.sparta.jupiterJazz;

import com.sparta.jupiterJazz.exceptions.AgeRangeException;
import com.sparta.jupiterJazz.exceptions.DateRangeException;
import com.sparta.jupiterJazz.exceptions.EmployeeIdException;
import com.sparta.jupiterJazz.exceptions.LastNameException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public interface DAO {

    ArrayList<Employee> getEmployees(DTO dto);

    Employee searchById(String id, DTO dto) throws EmployeeIdException;

    ArrayList<Employee> searchByLastName(String name, DTO dto) throws LastNameException;

    public ArrayList<Employee> searchByDateRange(Date firstDate, Date lastDate, DTO dto) throws DateRangeException;
    public ArrayList<Employee> searchByAgeRange(Date minDate, Date maxDate, DTO dto) throws AgeRangeException;

}
