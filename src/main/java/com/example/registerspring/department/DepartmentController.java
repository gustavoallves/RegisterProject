package com.example.registerspring.department;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {

    private final DepartmentMapper departmentMapper;
    public DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService, DepartmentMapper departmentMapper) {
        this.departmentService = departmentService;
        this.departmentMapper = departmentMapper;
    }

    //  GET -- Mandar requisicao para ENCONTRAR
    @GetMapping("/find/{id}")
    public ResponseEntity<?> createDepartment(@PathVariable Long id) {
        DepartmentDTO department = departmentService.findById(id);
        if (department != null) {
            return ResponseEntity.ok(department);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Department Id " + id + " not found.");
        }
    }

    //  GET -- Mandar requisicao para EXIBIR
    @GetMapping("/all")
    public ResponseEntity<List<DepartmentDTO>> showAllDepartment() {
        List<DepartmentDTO> department = departmentService.listDepartment();
        return ResponseEntity.ok(department);
    }

    //  POST -- Mandar requisicao para CRIAR
    @PostMapping("/add")
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO newDepartment = departmentService.createDepartment(departmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Department Created");
    }

    //  PUT -- Mandar requisicao para ALTERAR
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editDepartment(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO editedDepartment = departmentService.editDepartment(id, departmentDTO);
        if (departmentService.findById(id) != null) {
            return ResponseEntity.ok("Department Edited:\n" + editedDepartment.getName() + "\n" + editedDepartment.getCategory());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Department Id " + id + " not found.");
        }
    }

    //  DELETE -- Mandar requisicao para DELETAR
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        if (departmentService.findById(id) != null) {
            departmentService.deleteDepartment(id);
            return ResponseEntity.ok("Department " + id + " deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Department Id " + id + " not found.");
        }
    }

}
