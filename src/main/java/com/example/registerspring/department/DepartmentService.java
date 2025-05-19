package com.example.registerspring.department;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public List<DepartmentDTO> listDepartment() {
        List<DepartmentModel> department = departmentRepository.findAll();
        return department.stream()
                .map(departmentMapper::map)
                .collect(Collectors.toList());
    }

    public DepartmentDTO findById(Long id) {
        Optional<DepartmentModel> departmentById = departmentRepository.findById(id);
        return departmentById.map(departmentMapper::map).orElse(null);
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        DepartmentModel departmentModel = departmentMapper.map(departmentDTO);
        departmentModel = departmentRepository.save(departmentModel);
        return departmentMapper.map(departmentModel);
    }

    public DepartmentDTO editDepartment(Long id, DepartmentDTO departmentDTO) {
        Optional<DepartmentModel> departmentExist = departmentRepository.findById(id);
        if (departmentExist.isPresent()) {
            DepartmentModel departmentEdited = departmentMapper.map(departmentDTO);
            departmentEdited.setId(id);
            DepartmentModel departmentSave = departmentRepository.save(departmentEdited);
            return departmentMapper.map(departmentSave);
        }
        return null;
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

}
