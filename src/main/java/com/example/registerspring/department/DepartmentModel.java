package com.example.registerspring.department;

import com.example.registerspring.users.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_department")
public class DepartmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<UserModel> users;

    public DepartmentModel() {
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

    public void setName(String description) {
        this.name = description;
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

    public void setUsers(List<UserModel> user) {
        this.users = user;
    }
}