package com.example.registerspring.users;

import com.example.registerspring.common.exception.NotFoundException;
import com.example.registerspring.department.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final DepartmentRepository departmentRepository;
    private final UserMapper userMapper;
    private final DepartmentMapper departmentMapper;
    private final UserRepository userRepository;

    public UserService(DepartmentRepository departmentRepository, UserMapper userMapper, DepartmentMapper departmentMapper, UserRepository userRepository) {
        this.departmentRepository = departmentRepository;
        this.userMapper = userMapper;
        this.departmentMapper = departmentMapper;
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        DepartmentModel departmentModel = departmentRepository.findById(userRequestDTO.departmentId())
                .orElseThrow(() -> new NotFoundException("Department with id " + userRequestDTO.departmentId() + " not found."));
        DepartmentResponseDTO departmentResponseDTO = departmentMapper.toResponseDto(departmentModel);
        UserModel userToSave = userMapper.toModel(userRequestDTO);
        UserModel userSaved = userRepository.save(userToSave);
        UserResponseDTO userResponseDTO = userMapper.toResponseDto(userSaved);
        userResponseDTO.setDepartmentResponseDTO(departmentResponseDTO);
        return userResponseDTO;
    }

    public List<UserResponseDTO> listAllUser() {
        List<UserModel> users = userRepository.findAll();
        return userMapper.toResponseList(users);
    }

    public UserResponseDTO findById(Long id) {
        UserModel userById = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id " + id + " not found."));
        return userMapper.toResponseDto(userById);
    }

    public UserResponseDTO editUser(Long id, UserRequestDTO userRequestDTO) {
        UserModel userToEdit = userMapper.toModel(userRequestDTO);
        userToEdit.setId(id);
        UserModel userEdited = userRepository.save(userToEdit);
        return userMapper.toResponseDto(userEdited);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
