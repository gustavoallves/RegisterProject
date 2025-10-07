package com.example.registerspring.mapper;

import com.example.registerspring.dto.DepartmentRequestDTO;
import com.example.registerspring.dto.DepartmentResponseDTO;
import com.example.registerspring.entity.DepartmentModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    DepartmentModel toModel(DepartmentRequestDTO departmentRequestDTO);

    DepartmentResponseDTO toResponseDto(DepartmentModel departmentModel);

    List<DepartmentResponseDTO> toResponseList(List<DepartmentModel> departmentModels);
}
