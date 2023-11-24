package com.sparta.jupiterJazz.Validator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class userInputValidator {

    public static boolean validateNumEmployees(String userCommand){
        return Integer.parseInt(userCommand) <= 1000 && Integer.parseInt(userCommand) >= 1;
    }

    public static boolean validateEmployeeID(String userCommand){
        return (userCommand.length() <= 8 && !userCommand.isEmpty());
    }

    public static boolean validateDates(String firstDate, String secondDate){
        return Pattern.compile("\\d{4}\\/\\d{2}\\/\\d{2}").matcher(firstDate).find()
                && Pattern.compile("\\d{4}\\/\\d{2}\\/\\d{2}").matcher(secondDate).find();
        ///https://stackoverflow.com/questions/14862289/how-to-use-regex-in-java-to-pattern-match

    }

    public static boolean validateAgeInput(String firstAge, String secondAge){

        return Pattern.compile("\\d{1,2}").matcher(firstAge).find()
                && Pattern.compile("\\d{1,2}").matcher(secondAge).find();
    }

    public static boolean validateNameInput(String userCommand){
        return Pattern.compile("[a-zA-z]").matcher(userCommand).find();
    }
}
