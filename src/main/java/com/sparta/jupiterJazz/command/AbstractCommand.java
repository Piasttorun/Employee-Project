package com.sparta.jupiterJazz.command;

public abstract class AbstractCommand {
    private CommandTypeEnum commandType;

    public CommandTypeEnum getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandTypeEnum commandType) {
        this.commandType = commandType;
    }
}
