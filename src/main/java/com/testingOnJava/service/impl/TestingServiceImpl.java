package com.testingOnJava.service.impl;

import com.testingOnJava.dto.request.UserDto;
import com.testingOnJava.dto.response.ResponseDto;
import com.testingOnJava.model.User;
import com.testingOnJava.repository.UserRepository;
import com.testingOnJava.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

@Service
public class TestingServiceImpl implements TestingService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseDto createUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.username());
        user.setEmail(userDto.email());

        try {
            userRepository.save(user);
        }catch (Exception e) {
            return new ResponseDto(400, LocalDateTime.now());
        }

        return new ResponseDto(200, LocalDateTime.now());
    }
}
