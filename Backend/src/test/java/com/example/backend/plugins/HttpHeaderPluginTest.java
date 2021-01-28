package com.example.backend.plugins;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class HttpHeaderPluginTest {

    @Test
    public void contentDispositionHeaderExists_FilenameExists_ReturnFilename() {
        final String contentDispositionHeader = "Content-Disposition: attatchment; filename=\"mock.pdf\"";

        String expected = "mock.pdf";
        String result = HttpHeaderPlugin.extractFilename(contentDispositionHeader).orElse("");

        assertEquals(expected, result);
    }

    @Test
    public void contentDispositionHeaderExists_FilenameNotExists_ReturnEmpty() {
        final String contentDispositionHeader = "Content-Disposition: inline";

        Optional<String> expected = Optional.empty();
        Optional<String> result = HttpHeaderPlugin.extractFilename(contentDispositionHeader);

        assertEquals(expected, result);
    }

}