package com.example.registerspring.department;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("departments")
public class DepartmentController {

    private final DepartmentMapper departmentMapper;
    public DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService, DepartmentMapper departmentMapper) {
        this.departmentService = departmentService;
        this.departmentMapper = departmentMapper;
    }

    @PostMapping()
    public ResponseEntity<DepartmentResponseDTO> createDepartment(@Valid @RequestBody DepartmentRequestDTO departmentRequestDTO) {
        DepartmentResponseDTO departmentNew = departmentService.createDepartment(departmentRequestDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(departmentNew.id())
                .toUri();
        return ResponseEntity.created(location).body(departmentNew);
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentResponseDTO>> listAllDepartment() {
        return ResponseEntity.ok(departmentService.listAllDepartment());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> findDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> editDepartment(@PathVariable Long id, @Valid @RequestBody DepartmentRequestDTO departmentRequestDTO) {
        departmentService.findById(id);
        DepartmentResponseDTO departmentEdited = departmentService.editDepartment(id, departmentRequestDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(departmentEdited.id())
                .toUri();
        return ResponseEntity.created(location).body(departmentEdited);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department " + id + " deleted.");
    }

}
