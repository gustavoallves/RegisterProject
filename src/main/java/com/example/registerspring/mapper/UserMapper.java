package com.example.registerspring.mapper;

import com.example.registerspring.dto.UserRequestDTO;
import com.example.registerspring.dto.UserResponseDTO;
import com.example.registerspring.entity.UserModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserModel toModel(UserRequestDTO userRequestDTO);

    UserResponseDTO toResponseDto(UserModel userModel);

    List<UserResponseDTO> toResponseList(List<UserModel> userModels);
}