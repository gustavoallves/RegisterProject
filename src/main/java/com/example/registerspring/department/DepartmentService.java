package com.example.registerspring.department;

import com.example.registerspring.users.UserModel;
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

    public DepartmentModel editDepartment (Long id, DepartmentModel departmentEdited){
        if (departmentRepository.existsById(id)){
            departmentEdited.setId(id);
            return departmentRepository.save(departmentEdited);
        }
        return null;
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

}
