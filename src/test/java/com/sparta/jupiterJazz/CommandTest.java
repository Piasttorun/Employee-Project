package com.sparta.jupiterJazz;

import com.sparta.jupiterJazz.command.AbstractCommand;
import com.sparta.jupiterJazz.command.AbstractCommandFactory;
import com.sparta.jupiterJazz.command.CommandTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CommandTest {


    @Test
    @DisplayName("Test case 1 command is load")
     void case1LoadTrue() {
        AbstractCommand command = AbstractCommandFactory.parseString(1, "10");
        Assertions.assertEquals(CommandTypeEnum.LOAD, command.getCommandType());
    }


    @Test
    @DisplayName("Test case 2 command is employee id search")
    void case2LoadTrue() {
        AbstractCommand command = AbstractCommandFactory.parseString(2, "34562423");
        Assertions.assertEquals(CommandTypeEnum.EMPLOYEEID_SEARCH, command.getCommandType());
    }


    @Test
    @DisplayName("Test case 3 command is date range search")
    void case3LoadTrue() {
        AbstractCommand command = AbstractCommandFactory.parseString(3, "18/02/2019 19/03/2020");
        Assertions.assertEquals(CommandTypeEnum.DATE_RANGE_SEARCH, command.getCommandType());
    }


    @Test
    @DisplayName("Test case 4 command is age range search")
    void case4LoadTrue() {
        AbstractCommand command = AbstractCommandFactory.parseString(4, "18/02/2019 19/03/2020");
        Assertions.assertEquals(CommandTypeEnum.AGE_RANGE_SEARCH, command.getCommandType());
    }


    @Test
    @DisplayName("Test case 5 command is last name search")
    void case5LoadTrue() {
        AbstractCommand command = AbstractCommandFactory.parseString(5, "Rai");
        Assertions.assertEquals(CommandTypeEnum.LAST_NAME_SEARCH, command.getCommandType());
    }


}

