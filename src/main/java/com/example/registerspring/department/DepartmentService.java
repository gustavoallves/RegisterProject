package com.example.registerspring.department;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentModel> listDepartment() {
        return departmentRepository.findAll();
    }

    public DepartmentModel findById(Long id) {
        Optional<DepartmentModel> departmentById = departmentRepository.findById(id);
        return departmentById.orElse(null);
    }

    public DepartmentModel createDepartment(DepartmentModel departmentModel) {
        return departmentRepository.save(departmentModel);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

}
