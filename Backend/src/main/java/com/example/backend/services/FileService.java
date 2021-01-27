package com.example.backend.services;

import java.io.IOException;
import java.io.InputStream;

public interface FileService {

    String upload(InputStream fileStream, String contentDispositionHeader) throws IOException;

    void get(String fileId);

    void delete(String fileId);
}
