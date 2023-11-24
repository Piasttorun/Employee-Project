package com.sparta.jupiterJazz.Validator;

import java.util.regex.Pattern;

public class userInputValidator {

    public static boolean validateNOEmployees(String userCommand){
        return Integer.parseInt(userCommand) <=10000 && Integer.parseInt(userCommand)>=1;
    }

    public static boolean validateEmployeeID(String userCommand){
        return (userCommand.length() <= 8 && !userCommand.isEmpty());
    }

    public static boolean validateDates(String userCommand){
        return Pattern.compile("/^[0-9]{4}-[0-9]{2}-[0-9]{2}\\b\\s[0-9]{4}-[0-9]{2}-[0-9]{0,2}/").matcher(userCommand).find();
        ///https://stackoverflow.com/questions/14862289/how-to-use-regex-in-java-to-pattern-match

    }

    public static boolean validateAgeInput(String userCommand){
        return Pattern.compile("/^[0-9]{0,2}\\b\\s[0-9]{0,2}/").matcher(userCommand).find();
    }

    public static boolean validateNameInput(String userCommand){
        return Pattern.compile("/^[a-zA-z]+").matcher(userCommand).find();
    }
}
