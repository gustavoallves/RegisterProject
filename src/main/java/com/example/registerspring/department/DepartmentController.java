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
    public DepartmentModel createDepartment(@PathVariable Long id){
        return departmentService.findById(id);
    }

    //  GET -- Mandar requisicao para EXIBIR
    @GetMapping("/all")
    public List<DepartmentModel> showAllDepartment(){
        return departmentService.listDepartment();
    }

//  POST -- Mandar requisicao para CRIAR
    @PostMapping("/add")
    public DepartmentModel createDepartment(@RequestBody DepartmentModel departmentModel){
        return departmentService.createDepartment(departmentModel);
    }

//  PUT -- Mandar requisicao para ALTERAR
    @PutMapping("/edit/{id}")
    public DepartmentModel editDepartment(@PathVariable Long id, @RequestBody DepartmentModel departmentModel){
        return departmentService.editDepartment(id, departmentModel);
    }

//  DELETE -- Mandar requisicao para DELETAR
    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable Long id){
        departmentService.deleteDepartment(id);
    }

}
