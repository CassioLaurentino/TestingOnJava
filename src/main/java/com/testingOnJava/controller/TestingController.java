package com.testingOnJava.controller;

import com.testingOnJava.dto.request.UserDto;
import com.testingOnJava.dto.response.ResponseDto;
import com.testingOnJava.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {

    @Autowired
    TestingService testingService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@Validated @RequestBody UserDto userDto) {
        ResponseDto response = testingService.createUser(userDto);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.status()));
    }
}
