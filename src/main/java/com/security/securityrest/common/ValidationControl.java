package com.security.securityrest.common;

import com.security.securityrest.users.entity.user.AddUserRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationControl {
    private final static Pattern bigLetterPattern = Pattern.compile("\\p{Lu}");
    private final static Pattern digitPattern = Pattern.compile("\\d");

    public static boolean checkInput(AddUserRequest request) {
        Matcher matcherDigit = digitPattern.matcher(request.getPassword());
        Matcher matcherBigLetterPattern = bigLetterPattern.matcher(request.getPassword());

        try {
            if (request.getLogin().equals(null) || request.getPassword() == null || request.getName().equals(null)) {
                return false;
            } else if (matcherDigit.find() && matcherBigLetterPattern.find()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
           return false;
        }
    }
}
