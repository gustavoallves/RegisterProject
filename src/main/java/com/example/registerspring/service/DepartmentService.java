package com.example.registerspring.service;

import com.example.registerspring.common.exception.NotFoundException;
import com.example.registerspring.dto.DepartmentRequestDTO;
import com.example.registerspring.dto.DepartmentResponseDTO;
import com.example.registerspring.entity.DepartmentModel;
import com.example.registerspring.mapper.DepartmentMapper;
import com.example.registerspring.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentMapper departmentMapper;
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO) {
        DepartmentModel departmentToSave = departmentMapper.toModel(departmentRequestDTO);
        DepartmentModel departmentSaved = departmentRepository.save(departmentToSave);
        return departmentMapper.toResponseDto(departmentSaved);
    }

    public List<DepartmentResponseDTO> listAllDepartment() {
        List<DepartmentModel> departments = departmentRepository.findAll();
        return departmentMapper.toResponseList(departments);
    }

    public DepartmentResponseDTO findById(Long id) {
        DepartmentModel departmentModel = departmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Department with id " + id + " not found."));
        return departmentMapper.toResponseDto(departmentModel);
    }

    public DepartmentResponseDTO editDepartment(Long id, DepartmentRequestDTO departmentRequestDTO) {
        DepartmentModel departmentToEdit = departmentMapper.toModel(departmentRequestDTO);
        departmentToEdit.setId(id);
        DepartmentModel departmentEdited = departmentRepository.save(departmentToEdit);
        return departmentMapper.toResponseDto(departmentEdited);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

}
