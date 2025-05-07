package com.example.registerspring.department;

import com.example.registerspring.users.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import java.util.List;

public class DepartmentDTO {
        private Long id;
        private String name;
        private String category;
        private List<UserModel> users;

    public DepartmentDTO() {
    }

    public DepartmentDTO(String name, String category, List<UserModel> users) {
        this.name = name;
        this.category = category;
        this.users = users;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
