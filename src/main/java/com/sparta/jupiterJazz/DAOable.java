package com.sparta.jupiterJazz;

import java.util.ArrayList;
import java.util.Date;


public interface DAOable {

    ArrayList<Employee> getEmployees(DTOable DTOable);

    Employee searchById(String id, DTOable DTOable);

    ArrayList<Employee> searchByLastName(String name, DTOable DTOable);

    ArrayList<Employee> searchByDateRange(Date firstDate, Date lastDate, DTOable DTOable);

    ArrayList<Employee> searchByAgeRange(Date minDate, Date maxDate, DTOable DTOable);

    void setEmployees(ArrayList<Employee> employees, DTOable DTOable);

    int getNumCorrupt(DTOable DTOable);

    void setNumCorrupt(int numCorrupt, DTOable DTOable);
}