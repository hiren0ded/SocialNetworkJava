package com.hiren.social.socialnetwork.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utils for checking Regex based pattern matching
 */
public class PatternMatcher {

    private static final String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

    public static boolean emailMatcher(final String email){
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
