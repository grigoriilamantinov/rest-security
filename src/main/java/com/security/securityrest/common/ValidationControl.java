package com.security.securityrest.common;

import com.security.securityrest.users.entity.user.AddUserRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationControl {
    private final static Pattern bigLetterPattern = Pattern.compile("\\p{Lu}");
    private final static Pattern digitPattern = Pattern.compile("\\d");

    public static boolean checkInput(final AddUserRequest request) {
        final Matcher matcherDigit = digitPattern.matcher(request.getPassword());
        final Matcher matcherBigLetterPattern = bigLetterPattern.matcher(request.getPassword());

        if (request.getLogin() == null || request.getPassword() == null || request.getName() == null) {
            return false;
        } else {
            return matcherDigit.find() && matcherBigLetterPattern.find();
        }

    }
}
