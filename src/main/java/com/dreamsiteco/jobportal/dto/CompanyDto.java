package com.dreamsiteco.jobportal.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record CompanyDto(long id, String name, String logo, String industry, String size, BigDecimal rating,
                         String locations, Integer founded, String description, Integer employees, String website,
                         Instant CreatedAt) {


}
