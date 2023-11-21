package com.sparta.jupiterJazz;

import java.util.ArrayList;
import java.util.Date;

public interface DAO {
    Employee searchById(int id);

    ArrayList<Employee> searchByLastName(String name);

    ArrayList<Employee> searchByDateRange(Date firstDate, Date lastDate);

    ArrayList<Employee> searchByAgeRange(int minAge, int maxAge);

}
