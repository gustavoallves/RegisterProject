package com.example.registerspring.department;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {

    public DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //  GET -- Mandar requisicao para ENCONTRAR
    @GetMapping("/find/{id}")
    public DepartmentDTO createDepartment(@PathVariable Long id){
        return departmentService.findById(id);
    }

    //  GET -- Mandar requisicao para EXIBIR
    @GetMapping("/all")
    public List<DepartmentDTO> showAllDepartment(){
        return departmentService.listDepartment();
    }

//  POST -- Mandar requisicao para CRIAR
    @PostMapping("/add")
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO departmentDTO){
        return departmentService.createDepartment(departmentDTO);
    }

//  PUT -- Mandar requisicao para ALTERAR
    @PutMapping("/edit/{id}")
    public DepartmentDTO editDepartment(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO){
        return departmentService.editDepartment(id, departmentDTO);
    }

//  DELETE -- Mandar requisicao para DELETAR
    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }

}
