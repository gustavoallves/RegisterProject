package com.example.registerspring.department;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    public List<DepartmentModel> listDepartment() {
        return departmentRepository.findAll();
    }

    public DepartmentModel findById(Long id) {
        Optional<DepartmentModel> departmentById = departmentRepository.findById(id);
        return departmentById.orElse(null);
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        DepartmentModel departmentModel = departmentMapper.map(departmentDTO);
        departmentModel = departmentRepository.save(departmentModel);
        return departmentMapper.map(departmentModel);
    }

    public DepartmentModel editDepartment(Long id, DepartmentModel departmentEdited) {
        if (departmentRepository.existsById(id)) {
            departmentEdited.setId(id);
            return departmentRepository.save(departmentEdited);
        }
        return null;
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

}
