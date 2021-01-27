package com.example.backend.services;

import com.example.backend.plugins.HttpHeaderPlugin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class DefaultFileService implements FileService {

    private final static String FALLBACK_FILENAME = "%s.tmp";
    @Value("${com.example.backend.tempUploadDir}")
    private String tempUploadDir;

    @Override
    public String upload(InputStream fileStream, String contentDispositionHeader) throws IOException {

        String fileName = HttpHeaderPlugin.extractFilename(contentDispositionHeader)
                .orElse(String.format(FALLBACK_FILENAME, UUID.randomUUID().toString()));

        Path targetFile = Path.of(tempUploadDir, fileName);

        return "Bytes written: " + Files.copy(fileStream, targetFile);
    }

    @Override
    public void get(String fileId) {
        // TODO UUID validieren
    }

    @Override
    public void delete(String fileId) {
        // TODO UUID validieren
    }
}
