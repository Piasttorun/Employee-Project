package com.sparta.jupiterJazz.controller;

import com.sparta.jupiterJazz.command.AbstractCommand;
import com.sparta.jupiterJazz.command.CommandTypeEnum;
import com.sparta.jupiterJazz.command.OneParamCommand;
import com.sparta.jupiterJazz.command.TwoParamCommand;

public class MainController {

    private static OneParamCommand onePCommand;
    private static TwoParamCommand twoPCommand;


    // Main records we will be working with, this should return a DTO to controller.
    public static void chooseSearch(AbstractCommand command) {

        // Depending on what command is received, we will call appropriate DAO search.
        CommandTypeEnum commandType = command.getCommandType();
        switch(commandType) {
            case LOAD:
                //Load the data
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


    }


}
