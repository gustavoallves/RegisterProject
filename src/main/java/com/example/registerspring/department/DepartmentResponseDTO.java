package com.example.registerspring.department;

import com.example.registerspring.users.UserResponseDTO;

import java.util.List;

public record DepartmentResponseDTO(
        Long id,
        String name,
        String category,
        List<UserResponseDTO> users
) {
}
