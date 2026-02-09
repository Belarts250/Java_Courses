package com.example.model;

public class Validator {
    public static boolean isValidName(String name) {
        return name.matches("^[A-Za-z ]+$");
    }
    public static boolean isValidNumber(String num) {
        return num.matches("^\\d+$");
    }
}
