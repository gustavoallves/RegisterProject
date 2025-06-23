package com.example.registerspring.users;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserModel toModel(UserRequestDTO userRequestDTO);

    UserResponseDTO toResponseDto(UserModel userModel);

    List<UserResponseDTO> toResponseList(List<UserModel> userModels);
}