package com.testingOnJava.service.impl;

import com.testingOnJava.dto.request.UserDto;
import com.testingOnJava.dto.response.ResponseDto;
import com.testingOnJava.model.Address;
import com.testingOnJava.model.User;
import com.testingOnJava.repository.UserRepository;
import com.testingOnJava.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TestingServiceImpl implements TestingService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseDto createUser(UserDto userDto) {
        Address address = new Address();
        address.setStreet(userDto.address().street());
        address.setCity(userDto.address().city());
        address.setCountry(userDto.address().country());
        address.setState(userDto.address().state());
        address.setPostalCode(userDto.address().postalCode());

        User user = new User();
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setUsername(userDto.username());
        user.setEmail(userDto.email());
        user.setAddress(address);
        user.setPhoneNumber(userDto.phoneNumber());
        user.setDateOfBirth(userDto.dateOfBirth());
        user.setProfilePictureUrl(userDto.profilePictureUrl());

        try {
            userRepository.save(user);
        }catch (Exception e) {
            return new ResponseDto(400, LocalDateTime.now());
        }

        return new ResponseDto(200, LocalDateTime.now());
    }
}
