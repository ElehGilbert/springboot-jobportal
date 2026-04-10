package com.dreamsiteco.jobportal.dto;

import jakarta.validation.constraints.*;

import java.io.Serializable;

/**
 * DTO for {@link com.dreamsiteco.jobportal.entity.Contact}
 */
public record ContactRequestDto(
        @NotBlank(message = "Name cannot be empty")
        @Size(min= 5, max=50, message = "Name must be between 5 and 50 character")
        String name,
        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Invalid Email address")
        String email,

        @NotBlank(message = "UserType cannot be empty")
        @Pattern(regexp = "Job Seeker|Employer|Other",message = "User Type must be one of: Job Seeker, Employer or Other")//Here we are saying the userType field should have any of these values only
        String userType,

        @NotBlank(message = "Subject cannot be empty")
        @Size(min= 5, max=150, message = "Subject must be between 5 and 150 character")
        String subject,

        @NotBlank(message = "Message cannot be empty")
        @Size(min= 5, max=500, message = "Message must be between 5 and 500 character")
                                String message
) implements Serializable {

}