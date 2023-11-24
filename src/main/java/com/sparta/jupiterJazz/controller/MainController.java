package com.sparta.jupiterJazz.controller;

import com.sparta.jupiterJazz.*;
import com.sparta.jupiterJazz.command.AbstractCommand;
import com.sparta.jupiterJazz.command.CommandTypeEnum;
import com.sparta.jupiterJazz.command.OneParamCommand;
import com.sparta.jupiterJazz.command.TwoParamCommand;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.sparta.jupiterJazz.EmployeeDTOCreator.getEmployeeArraylist;
import static com.sparta.jupiterJazz.EmployeeDTOCreator.getNumOfCorruptFiles;

public class MainController {

    private static OneParamCommand onePCommand;
    private static TwoParamCommand twoPCommand;

    private static CommandTypeEnum commandType;

    private static String param1;
    private static String param2;
    private static  DAO dao = new EmployeeDAO();

    private static int numCorrupt = 0;

    private static DTO currentEmployeeDTO;

    public static DTO chooseSearch(AbstractCommand command) {

        extractParameters(command);
        try {
            switch(commandType) {
                case LOAD:
                    return loadNewDTO();
                case EMPLOYEEID_SEARCH:
                    return getIDSearchDto();
                case LAST_NAME_SEARCH:
                    return getLastNameSearchDto();
                case AGE_RANGE_SEARCH:
                    return getAgeRangeSearchDto();
                case DATE_RANGE_SEARCH:
                    return getDateRangeSearchDto();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static DTO getDateRangeSearchDto() throws ParseException {
        Date dateRange1 = parseDate(twoPCommand.getParam1());
        Date dateRange2 = parseDate(twoPCommand.getParam2());

        ArrayList<Employee> employees;
        employees = dao.searchByDateRange(dateRange1, dateRange2, currentEmployeeDTO);
        return createDTO(employees, numCorrupt);
    }

    private static DTO getAgeRangeSearchDto() throws ParseException {
        Date ageRange1 = parseDate(twoPCommand.getParam1());
        Date ageRange2 = parseDate(twoPCommand.getParam2());

        ArrayList<Employee> employees;
        employees = dao.searchByAgeRange(ageRange1, ageRange2, currentEmployeeDTO);
        return createDTO(employees, numCorrupt);
    }

    private static DTO getLastNameSearchDto() {
        String searchedName = onePCommand.getParam1();
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(dao.searchById(searchedName, currentEmployeeDTO));
        return createDTO(employees, numCorrupt);
    }

    private static DTO getIDSearchDto() {
        String searchedID = onePCommand.getParam1();
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(dao.searchById(searchedID, currentEmployeeDTO));
        return createDTO(employees, numCorrupt);
    }

    private static DTO loadNewDTO() throws IOException, ParseException {
        int numEmployees = Integer.parseInt(onePCommand.getParam1());
        ArrayList<Employee> employees = getEmployeeArraylist(numEmployees);
        numCorrupt = getNumOfCorruptFiles();
        currentEmployeeDTO = createDTO(employees, numCorrupt);
        System.out.println("Size: " + currentEmployeeDTO.getEmployees().size());
        return currentEmployeeDTO;
    }

    private static void extractParameters(AbstractCommand command) {
        commandType = command.getCommandType();
        if (command.getClass().equals(OneParamCommand.class)) {
            onePCommand = (OneParamCommand) command;
            param1 = onePCommand.getParam1();
        } else if ((command.getClass().equals(TwoParamCommand.class))) {
            twoPCommand = (TwoParamCommand) command;
            param1 = twoPCommand.getParam1();
            param2 = twoPCommand.getParam2();
        }
    }

    private static DTO createDTO(ArrayList<Employee> employees, int numCorrupt) {
        DTO dto = new EmployeeDTO();
        dto.setEmployees(employees);
        dto.setNumCorrupt(numCorrupt);
        return dto;
    }

    private static Date parseDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.parse(dateString);
    }

}
