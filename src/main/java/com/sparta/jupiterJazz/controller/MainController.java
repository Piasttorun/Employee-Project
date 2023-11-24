package com.sparta.jupiterJazz.controller;

import com.sparta.jupiterJazz.*;
import com.sparta.jupiterJazz.command.AbstractCommand;
import com.sparta.jupiterJazz.command.CommandTypeEnum;
import com.sparta.jupiterJazz.command.OneParamCommand;
import com.sparta.jupiterJazz.command.TwoParamCommand;
import com.sparta.jupiterJazz.exceptions.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.sparta.jupiterJazz.EmployeeDTOCreator.getEmployeeArraylist;
import static com.sparta.jupiterJazz.EmployeeDTOCreator.getNumOfCorruptFiles;
import static java.util.Objects.nonNull;

public class MainController {

    private static OneParamCommand onePCommand;
    private static TwoParamCommand twoPCommand;

    private static CommandTypeEnum commandType;

    private static String param1;
    private static String param2;
    private static  DAO dao = new EmployeeDAO();

    private static int numCorrupt = 0;

    private static DTO currentEmployeeDTO;

    public static DTO chooseSearch(AbstractCommand command)
            throws EmployeeIdException, AgeRangeException, DateRangeException,
            ParseException, IllegalArgumentException, IOException, NoRecordsLoadedException {

        extractParameters(command);
        try {
            switch(commandType) {
                case LOAD:
                    return loadNewDTO();
                case EMPLOYEEID_SEARCH:
                    checkRecordsLoaded();
                    return getIDSearchDto();
                case LAST_NAME_SEARCH:
                    checkRecordsLoaded();
                    return getLastNameSearchDto();
                case AGE_RANGE_SEARCH:
                    checkRecordsLoaded();
                    return getAgeRangeSearchDto();
                case DATE_RANGE_SEARCH:
                    checkRecordsLoaded();
                    return getDateRangeSearchDto();
            }
        } catch (EmployeeIdException | DateRangeException | LastNameException | AgeRangeException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (NoRecordsLoadedException e) {
            throw e;
        } catch (Exception e) {
            throw e;
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
        int age1 = Integer.parseInt(twoPCommand.getParam1());
        int age2 = Integer.parseInt(twoPCommand.getParam2());

        Date ageRange1 = getDateMinusInt(age1);
        Date ageRange2 = getDateMinusInt(age2);

        ArrayList<Employee> employees;
        employees = dao.searchByAgeRange(ageRange2, ageRange1, currentEmployeeDTO);
        return createDTO(employees, numCorrupt);
    }

    private static DTO getLastNameSearchDto() {
        String searchedName = onePCommand.getParam1().toLowerCase();
        ArrayList<Employee> employees;
        employees = dao.searchByLastName(searchedName, currentEmployeeDTO);
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




    private static void checkRecordsLoaded() throws NoRecordsLoadedException {
        if (currentEmployeeDTO != null) {} else {
            throw new NoRecordsLoadedException("No records have been loaded");
        }
    }

    private static Date getDateMinusInt(int numYears) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, numYears*-365);
        return (calendar.getTime());
    }
}
