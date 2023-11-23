package com.sparta.jupiterJazz.controller;

import com.sparta.jupiterJazz.*;
import com.sparta.jupiterJazz.command.AbstractCommand;
import com.sparta.jupiterJazz.command.CommandTypeEnum;
import com.sparta.jupiterJazz.command.OneParamCommand;
import com.sparta.jupiterJazz.command.TwoParamCommand;

import java.util.ArrayList;

import static com.sparta.jupiterJazz.EmployeeDTOCreator.getEmployeeArraylist;

public class MainController {

    private static OneParamCommand onePCommand;
    private static TwoParamCommand twoPCommand;

    private static DAO dao = new EmployeeDAO();



    // Main records we will be working with, this should return a DTO to controller.
    public static DTO chooseSearch(AbstractCommand command) {

        // Depending on what command is received, we will call appropriate DAO search.
        CommandTypeEnum commandType = command.getCommandType();
        switch(commandType) {
            case LOAD:
                onePCommand = (OneParamCommand) command;
                int num = Integer.parseInt(onePCommand.getParam1());
                try {
                    ArrayList<Employee> test = getEmployeeArraylist(num);
                    DTO dto = new EmployeeDTO() ;
                    dao.setEmployees(test, dto);
                    return dto;
                } catch (Exception e) {

                }
                break;
            case EMPLOYEEID_SEARCH:
                // We take the first parameter
                onePCommand = (OneParamCommand) command;
                onePCommand.getParam1();
            case LAST_NAME_SEARCH:
                // More logic
            case AGE_RANGE_SEARCH:
                twoPCommand = (TwoParamCommand) command;
                twoPCommand.getParam1();
                twoPCommand.getParam2();
         }

        return null;
    }


}
