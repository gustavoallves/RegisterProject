package com.example.registerspring.department;

import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public DepartmentModel map(DepartmentDTO departmentDTO) {
        DepartmentModel departmentModel = new DepartmentModel();

        departmentModel.setId(departmentDTO.getId());
        departmentModel.setName(departmentDTO.getName());
        departmentModel.setCategory(departmentDTO.getCategory());
        departmentModel.setUsers(departmentDTO.getUsers());

        return departmentModel;
    }

    public DepartmentDTO map(DepartmentModel departmentModel) {
        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setId(departmentModel.getId());
        departmentDTO.setName(departmentModel.getName());
        departmentDTO.setCategory(departmentModel.getCategory());
        departmentDTO.setUsers(departmentModel.getUsers());

        return departmentDTO;
    }


}
