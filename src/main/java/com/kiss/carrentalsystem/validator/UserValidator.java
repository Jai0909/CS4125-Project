package com.kiss.carrentalsystem.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    public boolean validateName(String user) {
        if (containsNumbers(user)) {
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
}
