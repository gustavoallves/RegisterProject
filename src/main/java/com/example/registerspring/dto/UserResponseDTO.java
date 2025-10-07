package com.example.registerspring.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
    private int age;
    @JsonProperty("department")
    @JsonIgnoreProperties("users")
    private DepartmentResponseDTO departmentResponseDTO;

    public UserResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public DepartmentResponseDTO getDepartmentResponseDTO() {
        return departmentResponseDTO;
    }

    public void setDepartmentResponseDTO(DepartmentResponseDTO departmentResponseDTO) {
        this.departmentResponseDTO = departmentResponseDTO;
    }
}
