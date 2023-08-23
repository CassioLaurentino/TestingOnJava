package com.testingOnJava.service;

import com.testingOnJava.dto.request.UserDto;
import com.testingOnJava.dto.response.ResponseDto;

public interface TestingService {

    public ResponseDto createUser(UserDto userDto);
}
