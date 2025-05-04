package com.example.registerspring.department;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("department")
public class DepartmentController {

//  GET -- Mandar requisicao para EXIBIR
    @GetMapping("/all")
    public String allDepartment(){
        return "All departments";
    }

//  POST -- Mandar requisicao para CRIAR
    @PostMapping("/add")
    public String createDepartment(){
        return "Department created";
    }

//  PUT -- Mandar requisicao para ALTERAR
    @PutMapping("/edit")
    public String editDepartment(){
        return "Department edited";
    }

//  DELETE -- Mandar requisicao para DELETAR
    @DeleteMapping("/delete")
    public String deleteDepartment(){
        return "Department deleted";
    }

}
