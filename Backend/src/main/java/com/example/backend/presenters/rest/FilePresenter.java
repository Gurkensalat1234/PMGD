package com.example.backend.presenters.rest;

import com.example.backend.general.Constants;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(Constants.REST_API_FILE_ENDPOINT)
public interface FilePresenter {

    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<String> uploadFile(HttpServletRequest httpServletRequest);

    @GetMapping(
            value = "/test"
    )
    ResponseEntity<String> test();
}
