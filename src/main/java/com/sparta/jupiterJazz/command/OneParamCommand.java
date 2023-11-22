package com.sparta.jupiterJazz.command;

public class OneParamCommand extends AbstractCommand{

    private String param1;

    OneParamCommand(CommandTypeEnum commandType, String param1) {
        setCommandType(commandType);
        this.param1 = param1;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }
}
