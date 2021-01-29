package com.example.backend.presenters.rest;

import com.example.backend.general.HttpConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequestMapping(HttpConstants.REST_API_FILE_ENDPOINT)
public interface FilePresenter {

    @PostMapping(
            value = "/upload",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<String> upload(HttpServletRequest httpServletRequest) throws IOException;

    @GetMapping(
            value = "/get/{fileId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<StreamingResponseBody> get(String fileId);

    @DeleteMapping(
            value = "/delete/{fileId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    void delete(String fileId);
}
