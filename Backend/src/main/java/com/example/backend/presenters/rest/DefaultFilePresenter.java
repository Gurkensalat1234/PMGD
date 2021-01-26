package com.example.backend.presenters.rest;

import com.example.backend.general.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DefaultFilePresenter implements FilePresenter {

    @Override
    public ResponseEntity<String> uploadFile(HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok("Mock answer");
    }

    @Override
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Mock answer");
    }
}
