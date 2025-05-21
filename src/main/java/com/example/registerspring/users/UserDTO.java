package com.example.registerspring.users;

import com.example.registerspring.department.DepartmentModel;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private int age;
    private DepartmentModel department;

    public UserDTO() {
    }

    public UserDTO(String name, String email, int age, DepartmentModel department) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.department = department;
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

    public DepartmentModel getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentModel department) {
        this.department = department;
    }

}