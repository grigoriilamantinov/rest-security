package com.security.soapcrud.common;

import com.security.soapcrud.users.entity.UserEntity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationControl {
    private final static Pattern bigLetterPattern = Pattern.compile("\\p{Lu}");
    private final static Pattern digitPattern = Pattern.compile("\\d");

    public static boolean checkInput(final UserEntity userEntity) {
        final Matcher matcherDigit = digitPattern.matcher(userEntity.getPassword());
        final Matcher matcherBigLetterPattern = bigLetterPattern.matcher(userEntity.getPassword());

        if (userEntity.getLogin() == null || userEntity.getPassword() == null || userEntity.getFirstName() == null) {
            return false;
        } else {
            return matcherDigit.find() && matcherBigLetterPattern.find();
        }
    }
}
