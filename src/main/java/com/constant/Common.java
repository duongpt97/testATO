package com.constant;

public class Common {

    private Common() {

    }

    public static final String REGEX = "\\b(?:[a-zA-Z]+\\d+|\\d+[a-zA-Z]+)[a-zA-Z0-9]*\\b";
    public static final String REGEX_NUMBER_CHARACTER = "(\\d+)([a-zA-Z]+)|([a-zA-Z]+)(\\d+)";
    public static final String REGEX_NUMBER_CHARACTER_V2 = "([a-zA-Z]+)(\\d+)([a-zA-Z]*)";


}
