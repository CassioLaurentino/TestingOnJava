package com.testingOnJava.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record ResponseDto(
        @JsonProperty("status") int status,
        @JsonProperty("timestamp") LocalDateTime at
) {}