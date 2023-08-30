package com.testingOnJava.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AddressDto(
        @JsonProperty("id") Long id,
        @JsonProperty("street") String street,
        @JsonProperty("city") String city,
        @JsonProperty("state") String state,
        @JsonProperty("postalCode") String postalCode,
        @JsonProperty("country") String country
) {}
