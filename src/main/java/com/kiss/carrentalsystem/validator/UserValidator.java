package com.kiss.carrentalsystem.validator;

import com.kiss.carrentalsystem.repo.UserRepo;
import org.apache.catalina.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {


    public boolean validateName(String name) {
        if (containsNumbers(name)) {
            return false;
        }
        return true;
    }

    public boolean validatePhone(String number) {
        if(containsLetters(number)){
            return false;
        }
        return true;
    }

    public boolean validatePassword(String password) {
        if (!containsNumbers(password) || !containsCapitalLetters(password) || password.length() < 8) {
            return false;
        }
        return true;
    }

    private static boolean containsNumbers(String input) {
        Pattern pattern = Pattern.compile(".*\\d.*");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private static boolean containsCapitalLetters(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsLetters(String input) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    }
