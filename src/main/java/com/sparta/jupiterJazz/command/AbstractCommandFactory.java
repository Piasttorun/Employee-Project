package com.sparta.jupiterJazz.command;

public class AbstractCommandFactory {

    public static AbstractCommand parseString(int option, String userInput) {
        AbstractCommand command;
        String[] params = userInput.split(" ");

        switch (option){
            case 1:
                command = new OneParamCommand(CommandTypeEnum.LOAD, params[0]);
                return command;
            case 2:
                command = new OneParamCommand(CommandTypeEnum.EMPLOYEEID_SEARCH, params[0]);
                return command;
            case 3:
                command = new TwoParamCommand(CommandTypeEnum.DATE_RANGE_SEARCH, params[0], params[1]);
                return command;
            case 4:
                command = new TwoParamCommand(CommandTypeEnum.AGE_RANGE_SEARCH, params[0], params[1]);
                return command;
            case 5:
                command = new OneParamCommand(CommandTypeEnum.LAST_NAME_SEARCH, params[0]);
                return command;
        }
            return null;
    }

}
