package com.example.registerspring.users;

import com.example.registerspring.department.DepartmentDTO;

public record UserResponseDTO(
        Long id,
        String name,
        String email,
        int age,
        DepartmentDTO departmentDTO
) {
}
