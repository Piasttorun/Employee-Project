package com.sparta.jupiterJazz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDAOTest {

    public static DTO dto = new EmployeeDTO();
    public static EmployeeDAO dao = new EmployeeDAO();
    public static Employee employee;
    public static ArrayList<Employee> employeeArrayList;


    @BeforeAll
    static void createDTO(){
        createInit();
    }

    private static void createInit() {
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = new SimpleDateFormat("MM/dd/yyyy").parse("8/16/1958");
            date2 = new SimpleDateFormat("MM/dd/yyyy").parse("5/23/1995");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        employee = new Employee("387647","Drs.","Shanika", 'D',"Tejada", 'F',"shanika.tejada@gmail.com",date1,date2,81253);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        dto.setEmployees(employees);
        dto.setNumCorrupt(4);
        employeeArrayList = new ArrayList<>(List.of(new Employee[]{employee}));
    }

    @Test
    @DisplayName("searchByID case where ID is in ArrayList")
    public void checkSearchByIdTrue(){
        Assertions.assertEquals(employee,dao.searchById("387647",dto));
    }

    @Test
    @DisplayName("searchByID case where ID is not in ArrayList")
    public void checkSearchByIdFalse(){
        try{
            Assertions.assertNull(dao.searchById("1", dto));
        }catch(Exception e ){
            System.out.println();
        }

    }

    @Test
    @DisplayName("searchByLastName case where Last Name is in ArrayList")
    public void checkSearchByLastNameTrue(){
        Assertions.assertEquals(employeeArrayList,dao.searchByLastName("Tejada",dto));
    }

    @Test
    @DisplayName("searchByLastName case where Last Name is not in ArrayList")
    public void checkSearchByLastNameFalse() {
        try {
            Assertions.assertEquals(new ArrayList<>(), dao.searchByLastName("AAABBB", dto));
        }catch(Exception e){
            System.out.println();
        }
    }

    @Test
    @DisplayName("searchByDateRange case where Date Range fits ArrayList")
    public void checkSearchByDateRangeTrue(){
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = new SimpleDateFormat("M/dd/yyyy").parse("4/23/1995");
            date2 = new SimpleDateFormat("M/dd/yyyy").parse("6/23/1995");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(employeeArrayList,dao.searchByDateRange(date1,date2,dto));
    }

    @Test
    @DisplayName("searchByDateRange case where Date Range (in different 2 digit month format) fits ArrayList")
    public void checkSearchByDateRangeTrueDoubleDigits(){
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = new SimpleDateFormat("MM/dd/yyyy").parse("11/23/1994");
            date2 = new SimpleDateFormat("MM/dd/yyyy").parse("12/23/1995");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(employeeArrayList,dao.searchByDateRange(date1,date2,dto));
    }

    @Test
    @DisplayName("searchByDateRange case where Date Range (in different 2 digit month format) fits ArrayList")
    public void checkSearchByDateRangeFalse(){
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = new SimpleDateFormat("MM/dd/yyyy").parse("11/23/1998");
            date2 = new SimpleDateFormat("MM/dd/yyyy").parse("12/23/1995");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        try {
            Assertions.assertEquals(new ArrayList<>(),dao.searchByDateRange(date1,date2,dto));
        }catch(Exception e){
            System.out.println();
        }
    }

    @Test
    @DisplayName("searchByAgeRange case where Date Range (in different 2 digit month format) fits ArrayList")
    public void checkSearchByAgeRangeTrue(){
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = new SimpleDateFormat("MM/dd/yyyy").parse("11/20/1955");
            date2 = new SimpleDateFormat("MM/dd/yyyy").parse("11/20/1962");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(employeeArrayList,dao.searchByAgeRange(date1,date2,dto));
    }

    @Test
    @DisplayName("searchByAgeRange case where Date Range (in different 2 digit month format) fits ArrayList")
    public void checkSearchByAgeRangeFalse(){
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = new SimpleDateFormat("MM/dd/yyyy").parse("11/23/1998");
            date2 = new SimpleDateFormat("MM/dd/yyyy").parse("12/23/1995");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        try{
            Assertions.assertEquals(new ArrayList<>(),dao.searchByAgeRange(date1,date2,dto));
        }catch(Exception e){
            System.out.println();
        }
    }
}