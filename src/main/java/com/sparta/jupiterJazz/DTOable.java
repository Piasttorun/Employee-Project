package com.sparta.jupiterJazz;

import java.util.ArrayList;

public interface DTOable {

    ArrayList<Employee> getEmployees();

    void setEmployees(ArrayList<Employee> employees);

    int getNumCorrupt();

    void setNumCorrupt(int numCorrupt);

}
