package com.sparta.jupiterJazz;

import java.util.ArrayList;

public interface DTO {

    ArrayList<Employee> getEmployees();

    void setEmployees(ArrayList<Employee> employees);

    int getNumCorrupt();

    void setNumCorrupt(int numCorrupt);

}
