package com.example.registerspring.dto;

import java.util.List;

public record DepartmentResponseDTO(
        Long id,
        String name,
        String category,
        List<UserResponseDTO> users
) {
}
