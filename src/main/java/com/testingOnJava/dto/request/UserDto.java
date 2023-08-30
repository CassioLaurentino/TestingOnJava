package com.testingOnJava.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDto(
        @JsonProperty("id") Long id,
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("username")String username,
        @JsonProperty("email") String email,
        @JsonProperty("address") AddressDto address,
        @JsonProperty("phoneNumber") String phoneNumber,
        @JsonProperty("dateOfBirth") String dateOfBirth,
        @JsonProperty("profilePictureUrl") String profilePictureUrl
) {}
