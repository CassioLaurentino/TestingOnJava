package com.testingOnJava.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDto(
        @JsonProperty("name") String username,
        @JsonProperty("email") String email
) {}