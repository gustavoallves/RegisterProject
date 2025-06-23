package com.example.registerspring.department;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentModel toModel(DepartmentRequestDTO departmentRequestDTO);

    DepartmentResponseDTO toResponseDto(DepartmentModel departmentModel);

    List<DepartmentResponseDTO> toResponseList(List<DepartmentModel> departmentModels);
}
