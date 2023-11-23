package com.sparta.jupiterJazz;


import java.util.ArrayList;

public class EmployeeDTO {

    private ArrayList<Employee> employees;
    private int numCorrupt;

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public int getNumCorrupt() {
        return numCorrupt;
    }

    public void setNumCorrupt(int numCorrupt) {
        this.numCorrupt = numCorrupt;
    }
}
