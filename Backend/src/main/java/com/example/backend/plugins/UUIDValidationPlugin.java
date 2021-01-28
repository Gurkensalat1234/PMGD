package com.example.backend.plugins;

import java.util.regex.Pattern;

public class UUIDValidationPlugin {

    private static final Pattern uuidPattern = Pattern.compile("([a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8})");

    public static boolean isValid(String uuid) {
        return uuidPattern.matcher(uuid).matches();
    }
}
