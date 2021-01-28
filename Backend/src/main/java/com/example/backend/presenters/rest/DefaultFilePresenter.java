package com.example.backend.presenters.rest;

import com.example.backend.services.FileService;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class DefaultFilePresenter implements FilePresenter {


    private final FileService fileService;

    @Autowired
    public DefaultFilePresenter(FileService fileService) {
        this.fileService = fileService;
    }


    @Override
    public ResponseEntity<String> upload(HttpServletRequest httpServletRequest) throws IOException {

        boolean isMultipart = ServletFileUpload.isMultipartContent(httpServletRequest);

        if (!isMultipart) return ResponseEntity.badRequest().body("Request is not a multipart request");

        ServletFileUpload upload = new ServletFileUpload();

        // Parse the request
        FileItemIterator iter = upload.getItemIterator(httpServletRequest);

        String result = "";

        while (iter.hasNext()) {
            FileItemStream item = iter.next();
            if (!item.isFormField()) {
                try (InputStream fileStream = item.openStream()) {
                    var headers = item.getHeaders();

                    result = fileService.upload(fileStream, headers.getHeader(HttpHeaders.CONTENT_DISPOSITION));
                }
            }
        }


        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<StreamingResponseBody> get(String fileId) {
        return null;
    }

    @Override
    public void delete(String fileId) {

    }
}
