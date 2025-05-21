package com.example.registerspring.users;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel map(UserDTO userDTO) {

        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());
        userModel.setAge(userDTO.getAge());
        userModel.setDepartment(userDTO.getDepartment());

        return userModel;
    }

    public UserDTO map(UserModel userModel) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setName(userModel.getName());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setAge(userModel.getAge());
        userDTO.setDepartment(userModel.getDepartment());

        return userDTO;
    }
}
