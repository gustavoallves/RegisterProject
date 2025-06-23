package com.example.registerspring.department;

import com.example.registerspring.users.UserModel;

import java.util.List;

public class DepartmentDTO {
    private Long id;
    private String name;
    private String category;
    private List<UserModel> users;

    public DepartmentDTO() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String departmentCategory) {
        this.category = departmentCategory;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
