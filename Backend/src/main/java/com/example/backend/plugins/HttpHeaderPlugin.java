package com.example.backend.plugins;

import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class HttpHeaderPlugin {

    private final static Pattern fileNamePattern = Pattern.compile("filename=\"([aA-zZ0-9.-]*)\"");

    public static Optional<String> extractFilename(String contentDispositionHeader) {
        try {
            Matcher matcher = fileNamePattern.matcher(contentDispositionHeader);
            matcher.find();
            return Optional.of(matcher.group(1));
        } catch (Exception ex) {
            return Optional.empty();
        }
    }
}
