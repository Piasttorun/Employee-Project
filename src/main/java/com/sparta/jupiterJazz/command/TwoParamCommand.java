package com.sparta.jupiterJazz.command;

public class TwoParamCommand extends AbstractCommand{

    private String param1;
    private String param2;

    TwoParamCommand(CommandTypeEnum commandType, String param1, String param2) {
        setCommandType(commandType);
        this.param1 = param1;
        this.param2 = param2;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }
}
