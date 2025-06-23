package com.example.registerspring.users;


import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.validation.constraints.*;

public record UserRequestDTO(
        @NotBlank(message = "User name cannot be blank.")
        @Size(min = 3, max = 100, message = "User name must be between 3 and 100 characters.")
        String name,
        @NotBlank(message = "User email cannot be blank.")
        @Size(min = 3, max = 100, message = "User email must be between 3 and 100 characters.")
        String email,
        @NotNull(message = "User age cannot be null.")
        int age,
        @NotNull(message = "Department id cannot be null.")
        @JsonGetter("department_id")
        Long departmentId
) {
}